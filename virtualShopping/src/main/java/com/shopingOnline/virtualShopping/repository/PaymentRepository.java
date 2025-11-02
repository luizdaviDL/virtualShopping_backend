package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // ✅ MÉTODO QUE VOCÊ PRECISA - VERIFICA POR STATUS
    boolean existsByOrderAndStatusPaymentIn(
            Order order,
            List<PaymentStatus> statusPayment
    );

    // ✅ ALTERNATIVA: Se quiser usar "status" em vez de "statusPayment"
    boolean existsByOrderAndStatusIn(
            Order order,
            List<PaymentStatus> status
    );

    // ✅ BUSCAR PAGAMENTOS POR PEDIDO
    List<Payment> findByOrder(Order order);

    // ✅ BUSCAR PAGAMENTO POR TRANSACTION ID
    Optional<Payment> findByTransactionId(String transactionId);

    // ✅ BUSCAR PAGAMENTOS POR STATUS
    List<Payment> findByStatusPayment(PaymentStatus statusPayment);

    // ✅ BUSCAR PAGAMENTOS POR TIPO E STATUS
    List<Payment> findByTypePaymentAndStatusPayment(
            String typePayment,
            PaymentStatus statusPayment
    );

    // ✅ VERIFICAR SE EXISTE PAGAMENTO APROVADO PARA UM PEDIDO
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM Payment p WHERE p.order = :order AND p.statusPayment = 'APPROVED'")
    boolean existsApprovedPaymentByOrder(@Param("order") Order order);

    // ✅ BUSCAR PAGAMENTOS POR INTERVALO DE DATA
    @Query("SELECT p FROM Payment p WHERE p.createdAt BETWEEN :startDate AND :endDate")
    List<Payment> findPaymentsByDateRange(
            @Param("startDate") java.util.Date startDate,
            @Param("endDate") java.util.Date endDate
    );

    // ✅ BUSCAR PAGAMENTOS COM ALTO RISCO DE FRAUDE
    @Query("SELECT p FROM Payment p WHERE p.fraudRiskScore > :minRiskScore")
    List<Payment> findHighRiskPayments(@Param("minRiskScore") double minRiskScore);

    // ✅ CONTAR PAGAMENTOS POR STATUS (para dashboard)
    @Query("SELECT p.statusPayment, COUNT(p) FROM Payment p GROUP BY p.statusPayment")
    List<Object[]> countPaymentsByStatus();

    // ✅ BUSCAR PAGAMENTOS PIX PENDENTES
    @Query("SELECT p FROM Payment p WHERE p.typePayment = 'PIX' AND p.statusPayment = 'PENDING'")
    List<Payment> findPendingPIXPayments();

    // ✅ BUSCAR ÚLTIMO PAGAMENTO DE UM PEDIDO
    @Query("SELECT p FROM Payment p WHERE p.order = :order ORDER BY p.createdAt DESC LIMIT 1")
    Optional<Payment> findLatestPaymentByOrder(@Param("order") Order order);
}