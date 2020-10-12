package com.ordapplicationdemo.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverrides({
@AssociationOverride(name = "primarykey.product",joinColumns = @JoinColumn(name = "productid")),
@AssociationOverride(name = "primarykey.orders",joinColumns = @JoinColumn(name = "orderid"))
})
public class OrderItems {
	
		@EmbeddedId
		private OrderItemsId primarykey;
		private Integer itemprice;
		private Integer quantity;
		private String itemname;
		
		
		
		public Orders getOrders() {
			return getPrimarykey().getOrders();
		}
		public void setOrders(Orders orders) {
			getPrimarykey().setOrders(orders);
		}
		public Product getProducts() {
			return getPrimarykey().getProduct();
		}
		public void setProducts(Product product) {
			getPrimarykey().setProduct(product);
		}
		
		
		
		public OrderItemsId getPrimarykey() {
			return primarykey;
		}
		public void setPrimarykey(OrderItemsId primarykey) {
			this.primarykey = primarykey;
		}
		public Integer getItemprice() {
			return itemprice;
		}
		public void setItemprice(Integer itemprice) {
			this.itemprice = itemprice;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getItemname() {
			return itemname;
		}
		public void setItemname(String itemname) {
			this.itemname = itemname;
		}
		
		
}
