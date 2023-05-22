package com.org.shubham.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_line_items")
@Entity
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String skuCode;

    private Double price;

    private Integer quantity;

    @ManyToOne
    private Orders orders;
}
