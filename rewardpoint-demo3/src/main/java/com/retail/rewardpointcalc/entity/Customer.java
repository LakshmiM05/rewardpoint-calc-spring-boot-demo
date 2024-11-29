package com.retail.rewardpointcalc.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_Id")
	private int customerId;
	@Column(name="customer_Name")
	private String customerName;
	@Column(name="address")
	private String address ;
	@Column(name="emailID")
	private String  emailID; 
	@Column(name="phone")
	private int  phone ;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	//@JoinColumn(name = "customer", referencedColumnName = "customer_Id")
	@Builder.Default
	
	//@JoinColumn( referencedColumnName = "customer_Id")
	// @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transActionList = new ArrayList<Transaction>();
	
	private Date  created_at;
	private String  created_by; 
	private Date  updated_at; 
	private String updated_by; 

}
