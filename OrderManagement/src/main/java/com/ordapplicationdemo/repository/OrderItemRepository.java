package com.ordapplicationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordapplicationdemo.model.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer>{

}
