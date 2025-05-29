package com.nicoletti.store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @EmbeddedId
    private OrderItemId id;

    private Double discount;
    private Integer quantity;
    private Double price;

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }


}
