package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.PaymentDto;
import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import com.shopingOnline.virtualShopping.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping(value = "/save")
    public PaymentDto save(@RequestBody PaymentSave data){
        return service.save(data);
    }

    @GetMapping
    public List<PaymentDto> findAll() {
        return service.findAll();
    }

    // READ - Listar com paginação
    @GetMapping("/paginated")
    public Page<PaymentDto> findAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findAllPaginated(page, size);
    }

    // READ - Buscar pagamento por ID
    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // READ - Buscar pagamentos por Order ID
    @GetMapping("/order/{orderId}")
    public List<PaymentDto> findByOrderId(@PathVariable Long orderId) {
        return service.findByOrderId(orderId);
    }

    // READ - Buscar pagamentos por Status (usando Enum como string)
    @GetMapping("/status/{status}")
    public List<PaymentDto> findByStatus(@PathVariable String status) {
        try {
            PaymentStatus paymentStatus = PaymentStatus.valueOf(status.toUpperCase());
            return service.findByStatus(paymentStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid payment status: " + status);
        }
    }

    // READ - Histórico de pagamentos por Client ID
    @GetMapping("/client/{clientId}")
    public List<PaymentDto> findPaymentHistoryByClientId(@PathVariable Long clientId) {
        return service.findPaymentHistoryByClientId(clientId);
    }

    // READ - Buscar pagamentos por tipo (usando Enum como string)
    @GetMapping("/type/{paymentType}")
    public List<PaymentDto> findByPaymentType(@PathVariable String paymentType) {
        try {
            PaymentType type = PaymentType.valueOf(paymentType.toUpperCase());
            return service.findByPaymentType(type);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid payment type: " + paymentType);
        }
    }

    // READ - Estatísticas
    @GetMapping("/stats")
    public Map<String, Object> getPaymentStats() {
        return service.getPaymentStats();
    }

    // READ - Buscar por período
    @GetMapping("/period")
    public List<PaymentDto> findByPeriod(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return service.findByPeriod(startDate, endDate);
    }

    // READ - Buscar por transaction ID
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<PaymentDto> findByTransactionId(@PathVariable String transactionId) {
        Optional<PaymentDto> payment = service.findByTransactionId(transactionId);
        return payment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ - Buscar pagamentos por cliente e status
    @GetMapping("/client/{clientId}/status/{status}")
    public List<PaymentDto> findByClientIdAndStatus(
            @PathVariable Long clientId,
            @PathVariable PaymentStatus status) {

        return service.findByClientIdAndStatus(clientId, status);
    }

}
