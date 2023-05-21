package com.org.shubham;

import com.org.shubham.dtos.ProductRequestDto;
import com.org.shubham.entities.Product;
import com.org.shubham.repositories.ProductRepository;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceApplicationTest
{

    @Autowired
    private MockMvc mockkMvc;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
        dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void shouldCreateProduct() throws Exception {

        ProductRequestDto productRequestDto =  createTestProduct("test","testing",35.03);
        String requestString = new ObjectMapper().writeValueAsString(productRequestDto);

        mockkMvc.perform(MockMvcRequestBuilders.post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
                .andExpect(status().isCreated());

        Assertions.assertEquals(1, productRepository.findAll().size());

    }

     ProductRequestDto createTestProduct(String productName,
                                         String description,Double productPrice) throws JsonProcessingException {

         ProductRequestDto productRequestDto = new ProductRequestDto();
         productRequestDto.setProductName(productName);
         productRequestDto.setDescription(description);
         productRequestDto.setProductPrice(productPrice);
         return productRequestDto;
     }

    @Test
    void getProductsTest() throws Exception{

        ProductRequestDto productRequestDto =  createTestProduct("test","testing",35.03);
        String requestString = new ObjectMapper().writeValueAsString(productRequestDto);

        mockkMvc.perform(MockMvcRequestBuilders.get("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestString))
                .andExpect(status().isOk());
    }

}
