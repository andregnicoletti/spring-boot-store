package com.nicoletti.store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public void setOrder(Order order) {
        this.id.setOrder(order);
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }

    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }

    public double getSubTotal() {
        return (price - discount) * quantity;
    }


}
