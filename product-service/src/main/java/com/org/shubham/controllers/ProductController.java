package com.org.shubham.controllers;


import com.org.shubham.dtos.ProductRequestDto;
import com.org.shubham.dtos.ProductResponseDto;
import com.org.shubham.entities.Product;
import com.org.shubham.payload.ApiResponse;
import com.org.shubham.services.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/product")
    public ResponseEntity<ApiResponse> createProducts(@Valid @RequestBody ProductRequestDto productDto) {
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(new
                ApiResponse("Product created with product Name "+product.getProductName(),true),HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> productDtoList = productService.getAllProducts();
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);


    }
}
