package com.shopingOnline.virtualShopping.enums;

public enum PaymentStatus {
    PENDING,
    PAID,
    CANCELED,
    PAYMENT_APPROVED,       // Pagamento aprovado: O pagamento foi confirmado, o pedido está sendo processado
    PROCESSING,             // Processando: O pedido está sendo preparado ou embalado
    CANCELLED,
    APPROVED, AWAITING_PAYMENT, FAILED, PAIED
}
