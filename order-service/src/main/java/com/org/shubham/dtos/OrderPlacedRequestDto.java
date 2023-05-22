package com.org.shubham.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlacedRequestDto {

   private List<OrderLineDto> orderLineDtoList = new ArrayList<>();
}
