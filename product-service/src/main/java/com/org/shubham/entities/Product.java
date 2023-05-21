package com.org.shubham.entities;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "products")
@Builder
public class Product extends  BaseEntity implements Serializable {

    @Id
    private String id;

    private String productName;

    private String description;

    private Double productPrice;
}
