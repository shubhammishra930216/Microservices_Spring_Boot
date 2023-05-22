package com.org.shubham.dtos;


import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {


    private String skuCode;

    private Double price;

    private Integer quantity;

}
