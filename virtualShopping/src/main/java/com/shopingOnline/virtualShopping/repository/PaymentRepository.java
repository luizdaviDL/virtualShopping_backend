package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // ✅ MÉTODO QUE VOCÊ PRECISA - VERIFICA POR STATUS
    boolean existsByOrderAndStatusPaymentIn(
            Order order,
            List<PaymentStatus> statusPayment
    );

    // ✅ BUSCAR PAGAMENTOS POR PEDIDO
    List<Payment> findByOrder(Order order);

    // ✅ BUSCAR PAGAMENTOS POR ORDER ID
    List<Payment> findByOrderId(Long orderId);

    // ✅ BUSCAR PAGAMENTO POR TRANSACTION ID
    Optional<Payment> findByTransactionId(String transactionId);

    // ✅ BUSCAR PAGAMENTOS POR STATUS
    List<Payment> findByStatusPayment(PaymentStatus statusPayment);

    // ✅ BUSCAR PAGAMENTOS POR TIPO E STATUS (CORRIGIDO - usando Enum)
    List<Payment> findByTypePaymentAndStatusPayment(
            PaymentType typePayment,  // Mudado de String para PaymentType
            PaymentStatus statusPayment
    );

    // ✅ VERIFICAR SE EXISTE PAGAMENTO APROVADO PARA UM PEDIDO
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM Payment p WHERE p.order = :order AND p.statusPayment = 'APPROVED'")
    boolean existsApprovedPaymentByOrder(@Param("order") Order order);

    // ✅ BUSCAR PAGAMENTOS POR INTERVALO DE DATA
    @Query("SELECT p FROM Payment p WHERE p.createdAt BETWEEN :startDate AND :endDate")
    List<Payment> findPaymentsByDateRange(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    // ✅ CONTAR PAGAMENTOS POR STATUS (para dashboard)
    @Query("SELECT p.statusPayment, COUNT(p) FROM Payment p GROUP BY p.statusPayment")
    List<Object[]> countPaymentsByStatus();

    // ✅ BUSCAR PAGAMENTOS PIX PENDENTES
    @Query("SELECT p FROM Payment p WHERE p.typePayment = 'PIX' AND p.statusPayment = 'PENDING'")
    List<Payment> findPendingPIXPayments();

    // ✅ BUSCAR ÚLTIMO PAGAMENTO DE UM PEDIDO
    @Query("SELECT p FROM Payment p WHERE p.order = :order ORDER BY p.createdAt DESC")
    List<Payment> findLatestPaymentByOrder(@Param("order") Order order);

    default Optional<Payment> findLatestPaymentByOrderLimit1(Order order) {
        List<Payment> payments = findLatestPaymentByOrder(order);
        return payments.stream().findFirst();
    }

    // ✅ BUSCAR PAGAMENTOS POR CLIENT ID
    List<Payment> findByOrder_ClientId(Long clientId);

    // ✅ BUSCAR PAGAMENTOS POR TIPO
    List<Payment> findByTypePayment(PaymentType paymentType);

    // ✅ CONTAR POR STATUS (CORRIGIDO - retorna Long)
    Long countByStatusPayment(PaymentStatus paymentStatus);

    // ✅ SOMAR VALORES POR STATUS (CORRIGIDO - retorna BigDecimal)
    @Query("SELECT COALESCE(SUM(p.value), 0) FROM Payment p WHERE p.statusPayment = :status")
    BigDecimal sumValueByStatusPayment(@Param("status") PaymentStatus status);

    // ✅ CONTAR POR TIPO (CORRIGIDO - retorna Long)
    Long countByTypePayment(PaymentType type);

    // ✅ BUSCAR POR INTERVALO DE DATA (usando método do Spring)
    List<Payment> findByCreatedAtBetween(Date startDate, Date endDate);

    // ✅ BUSCAR POR CLIENT ID E STATUS (CORRIGIDO)
    @Query("SELECT p FROM Payment p WHERE p.order.client.id = :clientId AND p.statusPayment = :status")
    List<Payment> findByClientIdAndStatus(@Param("clientId") Long clientId,
                                          @Param("status") PaymentStatus status);

    // ✅ NOVOS MÉTODOS ADICIONAIS

    // Buscar pagamentos por cliente e tipo
    @Query("SELECT p FROM Payment p WHERE p.order.client.id = :clientId AND p.typePayment = :type")
    List<Payment> findByClientIdAndType(@Param("clientId") Long clientId,
                                        @Param("type") PaymentType type);

    // Buscar pagamentos com valor maior que
    List<Payment> findByValueGreaterThan(BigDecimal value);

    // Buscar pagamentos por status e tipo
    List<Payment> findByStatusPaymentAndTypePayment(PaymentStatus status, PaymentType type);

    // Contar pagamentos por cliente
    @Query("SELECT COUNT(p) FROM Payment p WHERE p.order.client.id = :clientId")
    Long countByClientId(@Param("clientId") Long clientId);

    // Buscar pagamentos recentes (últimos 30 dias)
    @Query("SELECT p FROM Payment p WHERE p.createdAt >= :date")
    List<Payment> findRecentPayments(@Param("date") Date date);

    // Estatísticas de valor total por tipo
    @Query("SELECT p.typePayment, SUM(p.value) FROM Payment p WHERE p.statusPayment = 'APPROVED' GROUP BY p.typePayment")
    List<Object[]> sumValueByTypeAndApprovedStatus();
}