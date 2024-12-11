package com.retail.rewardpointcalc.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

/**
 * @author Dell
 *
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Jacksonized
@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_Id")
	//@JsonProperty
	private int customerId;
	@Column(name = "customer_Name")
	//@JsonProperty
	private String customerName;
	@Column(name = "address")
	private String address;
	@Column(name = "emailID")
	private String emailID;
	@Column(name = "phone")
	private int phone;

	@OneToMany
	@JoinColumn(name = "customer_id")
	@Builder.Default
	private List<Transaction> transActionList = new ArrayList<Transaction>();

	private Date created_at;
	private String created_by;
	private Date updated_at;
	private String updated_by;
	/*
	 * @JsonCreator public Customer() {
	 * 
	 * }
	 */
	/*
	 * public Customer(int customerId,String customerName) {
	 * this.customerId=customerId; this.customerName=customerName; }
	 */
	
	/*
	 * @JsonCreator public static Customer of(@JsonProperty("customerId") int
	 * customerId,
	 * 
	 * @JsonProperty("customerName") String customerName,
	 * 
	 * @JsonProperty("address") String address) { Customer person = new Customer();
	 * person.address = address; person.customerId = customerId;
	 * 
	 * Transaction emailObj = new Transaction(); emailObj.setTransAmt(100);
	 * 
	 * // person.email = emailObj;
	 * 
	 * return person; }
	 */
	  
	/*
	 * @JsonCreator public static Customer of(@JsonProperty("customerId") int
	 * customerId,
	 * 
	 * @JsonProperty("customerName") String customerName
	 * 
	 * ) { Customer person = new Customer();
	 * 
	 * person.customerId = customerId; person.customerName = customerName;
	 * //Transaction emailObj = new Transaction(); //emailObj.setTransAmt(100);
	 * 
	 * // person.email = emailObj;
	 * 
	 * return person; }
	 */
	
	
	 
}
