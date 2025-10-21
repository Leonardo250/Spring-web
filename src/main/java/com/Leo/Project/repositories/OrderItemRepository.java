package com.Leo.Project.repositories;

import com.Leo.Project.entities.OrderItem;
import com.Leo.Project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
