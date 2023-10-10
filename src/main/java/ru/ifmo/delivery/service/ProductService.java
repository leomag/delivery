package ru.ifmo.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.delivery.model.dto.ProductDiscountDto;
import ru.ifmo.delivery.model.dto.ProductDto;
import ru.ifmo.delivery.model.entity.ProductDiscountEntity;
import ru.ifmo.delivery.model.entity.ProductEntity;
import ru.ifmo.delivery.model.entity.ProductGroupEntity;
import ru.ifmo.delivery.model.entity.UserEntity;
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
                .productGroup(new ProductGroupEntity(productDto.productGroupId().productGroup()))
                .productDiscount(new ProductDiscountEntity(productDto.productDiscountId().nameDiscount(), productDto.productDiscountId().enabled()))
                .user(new UserEntity(productDto.userId().username(), productDto.userId().email()))
                .build();
        return productRepository.save(product);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}