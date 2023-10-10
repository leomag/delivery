package ru.ifmo.delivery.model;

import jakarta.persistence.*;
import lombok.*;

import javax.management.ConstructorParameters;

@Data
@Entity
@Table(name = "product_discount")
@NoArgsConstructor
public class ProductDiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_discount", nullable = false)
    private String nameDiscount;

    public ProductDiscountEntity(String nameDiscount, Boolean enabled) {
        this.nameDiscount = nameDiscount;
        this.enabled = enabled;
    }

    private Boolean enabled;
}
