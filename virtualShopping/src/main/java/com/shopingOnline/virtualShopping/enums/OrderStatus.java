package com.shopingOnline.virtualShopping.enums;

public enum OrderStatus {
    ORDER_CONFIRMED,     // Pedido Confirmado
    PAYMENT_APPROVED,    // Pagamento aprovado
    PROCESSING,          // Processando
    PREPARING_ORDER,     // Preparando seu pedido obs(quando entrar nessa parte entra o eum Shiping)
    SHIPPED,             // Enviado
    AWAITING_SHIPMENT,   // Aguardando envio
    DELIVERED
}
