package ru.ifmo.delivery.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Integer price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_group_id", referencedColumnName = "id", nullable = false)
    private ProductGroupEntity productGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_discount_id", referencedColumnName = "id")
    private ProductDiscountEntity productDiscount;

}
