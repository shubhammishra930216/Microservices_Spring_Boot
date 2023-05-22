package com.org.shubham.services;

import com.org.shubham.dtos.OrderPlacedRequestDto;
import com.org.shubham.dtos.OrderResponseDto;

import java.util.List;

public interface OrderService {

    String createOrder(OrderPlacedRequestDto orderPlacedRequestDto);

    OrderResponseDto getAllOrders(String  orderNumber);

}
