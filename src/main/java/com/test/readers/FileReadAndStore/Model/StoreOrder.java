package com.test.readers.FileReadAndStore.Model;

import java.math.BigDecimal;
import java.util.Date;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class StoreOrder {

	@CsvBindByName(column = "Row ID", required = true)
	private int id;
	
	@CsvBindByName(column = "Order ID", required = true)
	private String orderId;
	
	@CsvBindByName(column = "Order Date", required = true)
	@CsvDate(value = "dd.MM.yy")
	private Date orderDate;
	
	@CsvBindByName(column = "Ship Date" , required = true)
	@CsvDate(value = "dd.MM.yy")
	private Date  shipDate;
	
	@CsvBindByName(column = "Ship Mode")
	private String shipMode;
	
	@CsvBindByName(column = "Customer ID", required = true)
	private String customerId;
	
	@CsvBindByName(column = "Customer Name", required = true)
	private String customerName;
	
	@CsvBindByName(column = "Segment")
	private String 	segment;
	
	@CsvBindByName(column = "Country", required = true)
	private String country;
	
	@CsvBindByName(column = "City")
	private String city;
	
	@CsvBindByName(column = "State")
	private String state;
	
	@CsvBindByName(column = "Postal Code")
	private String postalCode;
	
	@CsvBindByName(column = "Region")
	private String region ;
	
	@CsvBindByName(column = "Product ID", required = true)
	private String productId;
	
	@CsvBindByName(column = "Category", required = true)
	private String category;
	
	@CsvBindByName(column = "Sub-Category")
	private String subCategory;
	
	@CsvBindByName(column = "Product Name")
	private String productName;
	
	@CsvBindByName(column = "Sales")
	private BigDecimal sales;
	
	@CsvBindByName(column = "Quantity", required = true)
	private int  quantity;
	

	@CsvBindByName(column = "Discount")
	private BigDecimal discount;
	

	@CsvBindByName(column = "Profit")
	private BigDecimal profit;
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}



	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}



	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * @return the shipDate
	 */
	public Date getShipDate() {
		return shipDate;
	}



	/**
	 * @param shipDate the shipDate to set
	 */
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}



	/**
	 * @return the shipMode
	 */
	public String getShipMode() {
		return shipMode;
	}



	/**
	 * @param shipMode the shipMode to set
	 */
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}



	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}



	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}



	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	/**
	 * @return the segment
	 */
	public String getSegment() {
		return segment;
	}



	/**
	 * @param segment the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}



	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}



	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}



	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}



	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}



	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}



	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}



	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}



	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}



	/**
	 * @return the sub_category
	 */
	public String getSubCategory() {
		return subCategory;
	}



	/**
	 * @param sub_category the sub_category to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}



	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}



	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}



	/**
	 * @return the sales
	 */
	public BigDecimal getSales() {
		return sales;
	}



	/**
	 * @param sales the sales to set
	 */
	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}



	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}



	/**
	 * @return the profit
	 */
	public BigDecimal getProfit() {
		return profit;
	}



	/**
	 * @param profit the profit to set
	 */
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}



	public StoreOrder() {
		// TODO Auto-generated constructor stub
	}



	public StoreOrder(int id, String orderId, Date orderDate, Date shipDate, String customerId, String customerName, String country,
			String productId, String category, int quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.customerId = customerId;
		this.customerName = customerName;
		this.country = country;
		this.productId = productId;
		this.category = category;
		this.quantity = quantity;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StoreOrder [id=" + id + ", orderId=" + orderId + ", orderDate=" + orderDate + ", shipDate=" + shipDate
				+ ", shipMode=" + shipMode + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", segment=" + segment + ", country=" + country + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", region=" + region + ", productId=" + productId + ", category="
				+ category + ", subCategory=" + subCategory + ", productName=" + productName + ", sales=" + sales
				+ ", quantity=" + quantity + ", discount=" + discount + ", profit=" + profit + "]";
	}
	
	
}
