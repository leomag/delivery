package ru.ifmo.delivery.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductDto(String nameProduct, Integer price, ProductGroupDto productGroupId, ProductDiscountDto productDiscountId) {
}
