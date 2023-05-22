package com.org.shubham.dtos;

import com.org.shubham.entities.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private String orderNumber;
    private List<OrderLineDto> orderLineItemsList = new ArrayList<>();
}
