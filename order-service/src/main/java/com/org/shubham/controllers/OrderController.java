package com.org.shubham.controllers;

import com.org.shubham.dtos.OrderPlacedRequestDto;
import com.org.shubham.dtos.OrderResponseDto;
import com.org.shubham.payloads.ApiResponse;
import com.org.shubham.repositories.OrderRepository;
import com.org.shubham.services.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/orders")
    public ResponseEntity<ApiResponse> placeOrder(@Valid @RequestBody OrderPlacedRequestDto orderPlacedRequestDto){
        String orderNumber = orderService.createOrder(orderPlacedRequestDto);
        return new ResponseEntity<>(new
                ApiResponse("Order Placed Successfully with order number:"+orderNumber,true), HttpStatus.CREATED);
    }

    @GetMapping("/orders/{orderNumber}/")
    public ResponseEntity<OrderResponseDto> getAllOrders(@PathVariable(name = "orderNumber") String orderNumber){
        OrderResponseDto orderResponseDto = orderService.getAllOrders(orderNumber);
        return new ResponseEntity<>(orderResponseDto,HttpStatus.FOUND);
    }
}
