package com.food.models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Double total;

	private String userName;

	private String address;

	private String phone;

	private String status;

	private String orderInfo;
	
	private String truck;
	
	private String city;
	
	private Timestamp time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String order) {
		this.orderInfo = order;
	}

	public String getTruck() {
		return truck;
	}

	public void setTruck(String truck) {
		this.truck = truck;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
