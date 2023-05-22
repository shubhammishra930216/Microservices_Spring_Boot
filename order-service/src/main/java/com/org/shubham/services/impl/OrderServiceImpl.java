package com.org.shubham.services.impl;

import com.org.shubham.dtos.OrderPlacedRequestDto;
import com.org.shubham.dtos.OrderResponseDto;
import com.org.shubham.entities.OrderLineItems;
import com.org.shubham.entities.Orders;
import com.org.shubham.repositories.OrderLineRepository;
import com.org.shubham.repositories.OrderRepository;
import com.org.shubham.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String createOrder(OrderPlacedRequestDto orderPlacedRequestDto) {
        Orders order = new Orders();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderPlacedRequestDto.getOrderLineDtoList()
                .stream()
                .map(orderPlacedRequestDto1 -> modelMapper.map(orderPlacedRequestDto1,OrderLineItems.class))
                .toList();

        //List<OrderLineItems> updatedOrderLineItems = orderLineItems.stream().map(orderLineItems1 -> orderLineItems1.setOrders())
        //order.setOrderLineItemsList(orderLineItems);
        Orders savedOrder = orderRepository.save(order);
        orderLineItems.forEach(orderLineItems2 -> orderLineItems2.setOrders(savedOrder));
        orderLineRepository.saveAll(orderLineItems);
        //OrderLineItems orderLineItems1 = new OrderLineItems();
        //orderLineItems1.setOrders(savedOrder);
        return savedOrder.getOrderNumber();



    }

    @Override
    public OrderResponseDto getAllOrders(String orderNumber) {

        Orders orders = orderRepository.findByOrderNumber(orderNumber);
       // Orders orders1 = orderRepository.findById(orderId)
        //        .orElseThrow(RuntimeException::new);

        //log.info("orders"+orders1.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList());

        OrderResponseDto orderResponseDto = modelMapper.map(orders,OrderResponseDto.class);
        log.info("orders"+orderResponseDto.getOrderLineItemsList());
        return orderResponseDto;

    }


}
