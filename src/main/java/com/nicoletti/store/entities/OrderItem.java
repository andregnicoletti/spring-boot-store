package com.nicoletti.store.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item_pedido")
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    private Double discount;
    private Integer quantity;
    private Double price;

    public Order getOrder() {
        return id.getOrder();
    }

    public Product getProduct() {
        return id.getProduct();
    }


}
