package ru.ifmo.delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Integer price;

    @OneToOne
    @JoinColumn(name = "product_group_id", referencedColumnName = "id", nullable = false)
    private ProductGroupEntity productGroup;

    @OneToOne
    @JoinColumn(name = "product_discount_id", referencedColumnName = "id")
    private ProductDiscountEntity productDiscount;

}
