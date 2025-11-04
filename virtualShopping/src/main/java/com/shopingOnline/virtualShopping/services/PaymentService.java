package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderDto;
import com.shopingOnline.virtualShopping.components.dtos.PaymentDto;
import com.shopingOnline.virtualShopping.components.payment.PaymentComponents;
import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.payment.PaymentValidationUtil;
import com.shopingOnline.virtualShopping.entity.ClientInformation;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.entity.UserBehavior;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import com.shopingOnline.virtualShopping.repository.ClientInformationRepository;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import com.shopingOnline.virtualShopping.repository.UserBehaviorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;
    @Autowired
    private PaymentValidationUtil validationUtil;
    @Autowired
    private PaymentComponents paymentComponents;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserBehaviorRepository userBehaviorRepository;
    @Autowired
    private ClientInformationRepository clientInformationRepository;


    public PaymentDto save(PaymentSave data) {
        validationUtil.validatePaymentData(data);
        Order order = validationUtil.findAndValidateOrder(data.getOrder());

        validationUtil.checkExistingPayment(order);

        validationUtil.validatePaymentAmount(data.getValue(), order.getTotalPrice());
        Payment payment = paymentComponents.createPaymentEntity(data, order);
        repository.save(payment);
        Optional<Order> orderData = orderRepository.findById(payment.getOrder().getId());
        Order orderUpdate = orderData.orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + payment.getOrder().getId()));

        orderUpdate.setStatusPayment(payment.getStatusPayment());
        orderRepository.save(orderUpdate);

        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setOrder(payment.getOrder().getId());
        dto.setTypePayment(payment.getTypePayment());
        dto.setStatusPayment(payment.getStatusPayment());
        dto.setValue(payment.getValue());
        dto.setDeviceFingerprint(payment.getDeviceFingerprint());
        dto.setIpAddress(payment.getIpAddress());
        dto.setUserAgent(payment.getUserAgent());
        dto.setLocation(payment.getLocation());
        dto.setTransactionId(payment.getTransactionId());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setCreatedAt(payment.getCreatedAt());
        dto.setOrder(order.getId());

        userBehaviorRepository.findByClientId(payment.clientId())
                .filter(behavior ->
                        behavior.getClient().getId() == payment.getOrder().getClient().getId() &&
                                payment.getValue().compareTo(behavior.getTotalShopping()) == 0
                )
                .ifPresent(behavior -> {
                    behavior.setPaymentTye(payment.getTypePayment());
                    userBehaviorRepository.save(behavior);
                });

        return dto;
    }

    public List<PaymentDto> findAll() {
        List<Payment> payments = repository.findAll();
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Listar todos com paginação
    public Page<PaymentDto> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Payment> paymentPage = repository.findAll(pageable);
        return paymentPage.map(this::convertToDto);
    }

    // Buscar pagamento por ID
    public PaymentDto findById(Long id) {
        Payment payment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));
        return convertToDto(payment);
    }

    // Buscar pagamentos por Order ID
    public List<PaymentDto> findByOrderId(Long orderId) {
        List<Payment> payments = repository.findByOrderId(orderId);
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Buscar pagamentos por Status (usando Enum)
    public List<PaymentDto> findByStatus(PaymentStatus status) {
        List<Payment> payments = repository.findByStatusPayment(status);
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Histórico de pagamentos por Client ID
    public List<PaymentDto> findPaymentHistoryByClientId(Long clientId) {
        // Verificar se cliente existe
        ClientInformation client = clientInformationRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));

        List<Payment> payments = repository.findByOrder_ClientId(clientId);
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Buscar pagamentos por tipo de pagamento (usando Enum)
    public List<PaymentDto> findByPaymentType(PaymentType paymentType) {
        List<Payment> payments = repository.findByTypePayment(paymentType);
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Estatísticas de pagamento
    public Map<String, Object> getPaymentStats() {
        Map<String, Object> stats = new HashMap<>();

        stats.put("totalPayments", repository.count());
        stats.put("successfulPayments", repository.countByStatusPayment(PaymentStatus.APPROVED));
        stats.put("pendingPayments", repository.countByStatusPayment(PaymentStatus.PENDING));
        stats.put("failedPayments", repository.countByStatusPayment(PaymentStatus.FAILED));
        stats.put("cancelledPayments", repository.countByStatusPayment(PaymentStatus.CANCELLED));
        stats.put("totalRevenue", repository.sumValueByStatusPayment(PaymentStatus.APPROVED));

        // Adicionar contagem por tipo de pagamento
        for (PaymentType type : PaymentType.values()) {
            stats.put(type.name().toLowerCase() + "Count", repository.countByTypePayment(type));
        }

        // Adicionar estatísticas adicionais
        try {
            List<Object[]> revenueByType = repository.sumValueByTypeAndApprovedStatus();
            Map<String, BigDecimal> revenueByTypeMap = new HashMap<>();
            for (Object[] result : revenueByType) {
                PaymentType paymentType = (PaymentType) result[0];
                BigDecimal revenue = (BigDecimal) result[1];
                revenueByTypeMap.put(paymentType.name().toLowerCase(), revenue);
            }
            stats.put("revenueByType", revenueByTypeMap);
        } catch (Exception e) {
            stats.put("revenueByType", Collections.emptyMap());
        }

        return stats;
    }

    // Buscar pagamentos por período
    public List<PaymentDto> findByPeriod(Date startDate, Date endDate) {
        List<Payment> payments = repository.findByCreatedAtBetween(startDate, endDate);
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Buscar por transaction ID
    public Optional<PaymentDto> findByTransactionId(String transactionId) {
        return repository.findByTransactionId(transactionId)
                .map(this::convertToDto);
    }

    // Método auxiliar para converter Payment para PaymentDto
    private PaymentDto convertToDto(Payment payment) {
        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setOrder(payment.getOrder().getId());
        dto.setTypePayment(payment.getTypePayment());
        dto.setStatusPayment(payment.getStatusPayment());
        dto.setValue(payment.getValue());
        dto.setDeviceFingerprint(payment.getDeviceFingerprint());
        dto.setIpAddress(payment.getIpAddress());
        dto.setUserAgent(payment.getUserAgent());
        dto.setLocation(payment.getLocation());
        dto.setTransactionId(payment.getTransactionId());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setCreatedAt(payment.getCreatedAt());

        return dto;
    }

    public List<PaymentDto> findByClientIdAndStatus(Long clientId, PaymentStatus status) {
        // Verificar se cliente existe
        clientInformationRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));

        List<Payment> payments = repository.findByClientIdAndStatus(clientId, status);
        return payments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }



}
