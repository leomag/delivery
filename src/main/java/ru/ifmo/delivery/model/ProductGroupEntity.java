package ru.ifmo.delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_group")
@NoArgsConstructor
public class ProductGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productGroup;

    public ProductGroupEntity(String productGroup) {
        this.productGroup = productGroup;
    }
}
