package com.ordapplicationdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordapplicationdemo.model.Product;
import com.ordapplicationdemo.repository.ProductRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(value = "/insertProduct")
	public String insertProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product Saved";
	}
	
}
