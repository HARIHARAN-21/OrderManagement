package com.ordapplicationdemo.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordapplicationdemo.model.Customer;
import com.ordapplicationdemo.model.OrderItems;
import com.ordapplicationdemo.model.Orders;
import com.ordapplicationdemo.model.Product;
import com.ordapplicationdemo.repository.CustomerRepository;
import com.ordapplicationdemo.repository.OrderItemRepository;
import com.ordapplicationdemo.repository.OrderRepository;
import com.ordapplicationdemo.repository.ProductRepository;


@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	private OrderItemRepository orderitemRepository;
	
	@PostMapping(value="/insertorder")
	public String insertOrder(@RequestBody Orders orders) {
		Orders ord = orderRepository.save(orders);
		Set<OrderItems> itemlist = orders.getOrderitems();
		itemlist.forEach(item->{item.getPrimarykey().setOrders(ord);
		orderitemRepository.save(item);
		});
		return "Order placed";
	}
	
	
	@GetMapping(value="/notsold")
	public List<Product> notsold(){
		return productRepository.selectproductid();
	}
	
	@GetMapping(value="/notbuy")
	public List<Customer> notbuy(){
		return customerRepository.selectcustomerid();
	}
	
	@GetMapping(value="/particularprod/{id}")
	public List<String> particularprod(@PathVariable Integer id){
		return orderRepository.getparticularprod(id);
	}
	
	
	
	
	
}
