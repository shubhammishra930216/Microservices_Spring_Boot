package com.org.shubham.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id",nullable = false)
    private Long Id;

    @NaturalId
    @Column(name="order_num")
    private String orderNumber;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderLineItems> orderLineItemsList = new ArrayList<>();

}
