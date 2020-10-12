package com.ordapplicationdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ordapplicationdemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "select * from Product_Info where productid not in (Select productid from Order_Items)",nativeQuery = true)
	List<Product> selectproductid();
}
