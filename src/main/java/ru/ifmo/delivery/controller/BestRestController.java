package ru.ifmo.delivery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.delivery.model.ProductEntity;
import ru.ifmo.delivery.service.ProductService;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/delivery")
@RestController
public class BestRestController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
