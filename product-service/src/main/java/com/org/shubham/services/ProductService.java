package com.org.shubham.services;

import com.org.shubham.dtos.ProductRequestDto;
import com.org.shubham.dtos.ProductResponseDto;
import com.org.shubham.entities.Product;

import java.util.List;

public interface ProductService {

   Product createProduct(ProductRequestDto productDto);

   List<ProductResponseDto> getAllProducts();
}
