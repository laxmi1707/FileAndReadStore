package com.test.readers.FileReadAndStore.Model;

import java.math.BigDecimal;
import java.util.Date;

public class StoreOrderBuilder {

	private int id;
	
	private String orderId;
	
	private Date orderDate;
	
	private Date  shipDate;
	
	private String shipMode;
	
	private String customerId;
	
	private String customerName;
	
	private String 	segment;
	
	private String country;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private String region ;
	
	private String productId;
	
	private String category;
	
	private String subCategory;
	
	private String productName;
	
	private BigDecimal sales;
	
	private int  quantity;
	
	private BigDecimal discount;
	
	private BigDecimal profit;
	
	public StoreOrderBuilder withId(int id){
		this.id = id;
		return this;
	}
	
	public StoreOrderBuilder withOrderId(String orderId){
		this.orderId = orderId;
		return this;
	}
	
	public StoreOrderBuilder withOrderDate(Date orderDate){
		this.orderDate = orderDate;
		return this;
	}
	
	public StoreOrderBuilder withShipDate(Date shipDate){
		this.shipDate = shipDate;
		return this;
	}
	
	public StoreOrderBuilder withCustomerId(String customerId){
		this.customerId = customerId;
		return this;
	}
	
	public StoreOrderBuilder withCustomerName(String name){
		this.customerName = name;
		return this;
	}
	
	public StoreOrderBuilder withSegment(String segment){
		this.segment = segment;
		return this;
	}
	
	public StoreOrderBuilder withCountry(String country){
		this.country = country;
		return this;
	}
	
	public StoreOrderBuilder withState(String state){
		this.state = state;
		return this;
	}
	
	public StoreOrderBuilder withCity(String city){
		this.city = city;
		return this;
	}
	
	public StoreOrderBuilder withPostalCode(String postalcode){
		this.postalCode = postalcode;
		return this;
	}
	
	public StoreOrderBuilder withRegion(String region){
		this.region = region;
		return this;
	}
	
	public StoreOrderBuilder withProductId(String prodID){
		this.productId = prodID;
		return this;
	}
	
	public StoreOrderBuilder withCategory(String category){
		this.category = category;
		return this;
	}
	
	public StoreOrderBuilder withProductName(String prodName){
		this.productName = prodName;
		return this;
	}
	
	public StoreOrderBuilder withSales(BigDecimal sales){
		this.sales = sales;
		return this;
	}
	
	public StoreOrderBuilder withQuantity(int quantity){
		this.quantity = quantity;
		return this;
	}
	
	public StoreOrderBuilder withProfit(BigDecimal profit){
		this.profit = profit;
		return this;
	}
	
	public StoreOrderBuilder withDiscount(BigDecimal discount){
		this.discount = discount;
		return this;
	}
	
	public StoreOrderBuilder withShipMode(String shipMode){
		this.shipMode = shipMode;
		return this;
	}
	
	
	public StoreOrder build(){
		StoreOrder st = new StoreOrder(this.id, this.orderId, this.orderDate, this.shipDate, this.customerId, this.customerName, this.country,
				this.productId, this.category, this.quantity);
		st.setSubCategory(this.subCategory);
		st.setProductName(this.productName);
		st.setCountry(this.country);
		st.setCity(this.city);
		st.setState(this.state);
		st.setRegion(this.region);
		st.setPostalCode(this.postalCode);
		st.setSales(this.sales);
		st.setDiscount(this.discount);
		st.setProfit(this.profit);
		return st;
	}
	
	public StoreOrderBuilder() {
		
	}


}
