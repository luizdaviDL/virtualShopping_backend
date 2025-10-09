package com.shopingOnline.virtualShopping.enums;

public enum OrderStatus {
    DRAFT,
    AWAITING_PAYMENT,    // Pedido confirmado, aguardando pagamento
    PAYMENT_APPROVED,    // Pagamento aprovado
    PROCESSING,          // Processando
    PREPARING_ORDER,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
