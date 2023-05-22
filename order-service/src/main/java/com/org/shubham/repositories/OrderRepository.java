package com.org.shubham.repositories;

import com.org.shubham.dtos.OrderResponseDto;
import com.org.shubham.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

    Orders findByOrderNumber(String orderNUmber);
}
