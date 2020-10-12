package com.ordapplicationdemo.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Order_Info")
public class Orders {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer orderid;
		
		@Column(name = "orderdate")
		private LocalDate orderdate = LocalDate.now();
		
		@ManyToOne(optional = false)
		@JoinColumn(name="customerid")
		private Customer customer;
		
		@OneToMany(mappedBy = "primarykey.orders")
		private Set<OrderItems> orderitems = new HashSet<>();
		
		public Integer getOrderid() {
		return orderid;
		}
		public void setOrderid(Integer orderid) {
		this.orderid = orderid;
		}
		
		public LocalDate getOrderdate() {
			return orderdate;
		}
		public void setOrderdate(LocalDate orderdate) {
			this.orderdate = orderdate;
		}
		
		public Customer getCustomer() {
		return customer;
		}
		public void setCustomer(Customer customer) {
		this.customer = customer;
		}
		public Set<OrderItems> getOrderitems() {
			return orderitems;
		}
		public void setOrderitems(Set<OrderItems> orderitems) {
			this.orderitems = orderitems;
		}
		

}