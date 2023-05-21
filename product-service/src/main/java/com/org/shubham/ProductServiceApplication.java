package com.org.shubham;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product Service",
                   version="0.01",
        description = "API definition for Product Service"
)
)
public class ProductServiceApplication
{
    public static void main( String[] args )

    {
        try {
            SpringApplication.run(ProductServiceApplication.class, args);
           } catch (Exception e) {
         e.printStackTrace();
     }
    }
}

