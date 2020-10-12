package com.ordapplicationdemo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderItemsId implements Serializable{
		@ManyToOne(cascade = CascadeType.ALL )
		private Product product;
		
		@ManyToOne(cascade = CascadeType.ALL)
		private Orders orders;

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Orders getOrders() {
			return orders;
		}

		public void setOrders(Orders orders) {
			this.orders = orders;
		}
		
		


}
