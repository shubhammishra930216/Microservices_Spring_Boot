package com.org.shubham.services.impl;

import com.org.shubham.dtos.ProductRequestDto;
import com.org.shubham.dtos.ProductResponseDto;
import com.org.shubham.entities.Product;
import com.org.shubham.exceptions.ResourceAlreadyExistException;
import com.org.shubham.repositories.ProductRepository;
import com.org.shubham.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Product createProduct(ProductRequestDto productDto) {
        Product product= productRepository.findByProductNameIgnoreCase(productDto.getProductName());
        if ( product != null){
            throw  new ResourceAlreadyExistException("Product","ProductName", productDto.getProductName());

        }else{
            log.info("given Price:{}",productDto.getProductPrice());
            Product requestedProduct = modelMapper.map(productDto,Product.class);

            Product savedProduct = productRepository.save(requestedProduct);
            return savedProduct;
        }

    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class)).toList();
    }
}
