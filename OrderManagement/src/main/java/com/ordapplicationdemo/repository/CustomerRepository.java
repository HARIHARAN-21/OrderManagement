package com.ordapplicationdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ordapplicationdemo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value = "select * from Customer_Info where customerid not in (Select customerid from Order_Info)",nativeQuery = true)
	List<Customer> selectcustomerid();
}
