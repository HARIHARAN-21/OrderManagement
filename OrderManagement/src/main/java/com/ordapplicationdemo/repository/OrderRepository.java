package com.ordapplicationdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ordapplicationdemo.model.Customer;
import com.ordapplicationdemo.model.Orders;
import com.ordapplicationdemo.model.Product;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

	@Query(value="Select customername from Customer_Info where customerid  = ANY (Select customerid from Order_Info where  orderid in (Select orderid from Order_Items where productid =?))",nativeQuery = true)
	List<String> getparticularprod(Integer id);
}
