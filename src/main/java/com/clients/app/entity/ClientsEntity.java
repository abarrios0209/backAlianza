package com.clients.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class ClientsEntity {
	
	
	
	@Id
	@Column(name = "shared_key")
	private String sharedKey;
	@Column(name="business_id")
	private String businessId;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="data_add")
	private Date dataAdd;
	@Column(name="start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	
	

	public ClientsEntity(String businessId, String email, String phone, Date dataAdd, Date startDate,
			Date endDate) {
		super();
		this.businessId = businessId;
		this.email = email;
		this.phone = phone;
		this.dataAdd = dataAdd;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ClientsEntity() {
		super();
	}

	public ClientsEntity(String sharedKey, String businessId, String email, String phone, Date dataAdd,
			Date startDate, Date endDate) {
		super();
		this.sharedKey = sharedKey;
		this.businessId = businessId;
		this.email = email;
		this.phone = phone;
		this.dataAdd = dataAdd;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getSharedKey() {
		return sharedKey;
	}

	public void setSharedKey(String sharedKey) {
		this.sharedKey = sharedKey;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDataAdd() {
		return dataAdd;
	}

	public void setDataAdd(Date dataAdd) {
		this.dataAdd = dataAdd;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
