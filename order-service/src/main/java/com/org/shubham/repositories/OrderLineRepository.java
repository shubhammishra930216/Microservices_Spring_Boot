package com.org.shubham.repositories;

import com.org.shubham.entities.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineItems,Long> {

}
