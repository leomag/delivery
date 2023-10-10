package ru.ifmo.delivery.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_discount")
@NoArgsConstructor
public class ProductDiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameDiscount;

    private Boolean enabled;

    public ProductDiscountEntity(String nameDiscount, Boolean enabled) {
        this.nameDiscount = nameDiscount;
        this.enabled = enabled;
    }
}
