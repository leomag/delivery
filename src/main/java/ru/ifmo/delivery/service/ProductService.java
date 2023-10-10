package ru.ifmo.delivery.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ifmo.delivery.model.ProductDiscountEntity;
import ru.ifmo.delivery.model.ProductDto;
import ru.ifmo.delivery.model.ProductEntity;
import ru.ifmo.delivery.model.ProductGroupEntity;
import ru.ifmo.delivery.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity save(ProductDto productDto) {
        var product = ProductEntity.builder()
                .nameProduct(productDto.nameProduct())
                .price(productDto.price())
                .productGroup(
                        new ProductGroupEntity(productDto.productGroupId().productGroup())
                )
                .productDiscount(
                        new ProductDiscountEntity(productDto.productDiscountId().nameDiscount(), productDto.productDiscountId().enabled()))
                .build();
        return productRepository.save(product);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}