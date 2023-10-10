package ru.ifmo.delivery.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Integer price;

    @Cascade(value = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "product_group_id", referencedColumnName = "id", nullable = false)
    private ProductGroupEntity productGroup;

    @Cascade(value = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "product_discount_id", referencedColumnName = "id")
    private ProductDiscountEntity productDiscount;

    @Cascade(value = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
