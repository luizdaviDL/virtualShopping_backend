package com.shopingOnline.virtualShopping.enums;

public enum OrderStatus {
    DRAFT,                  // Rascunho: Pedido criado, mas ainda não confirmado
    AWAITING_PAYMENT,       // Aguardando pagamento: O pedido foi confirmado, mas o pagamento ainda não foi processado
    PAYMENT_APPROVED,       // Pagamento aprovado: O pagamento foi confirmado, o pedido está sendo processado
    PROCESSING,             // Processando: O pedido está sendo preparado ou embalado
    SHIPPED,                // Enviado: O pedido foi enviado
    DELIVERED,              // Entregue: O pedido foi entregue com sucesso
    CANCELLED,
}
