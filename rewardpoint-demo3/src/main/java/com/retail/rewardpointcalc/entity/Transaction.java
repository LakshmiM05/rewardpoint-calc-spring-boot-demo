package com.retail.rewardpointcalc.entity;

import java.sql.Date;

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
public class Transaction {
	
	 //@ManyToOne
	   // @JoinColumn(name = "customer_Id")
	@ManyToOne
	
	 @JoinColumn(name = "customer", referencedColumnName = "customer_Id")
	private Customer customer;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="trans_Id")
	private int transId;
	@Column(name="trans_Amt")
	private int transAmt;
	@Column(name="reward_Points")
	private int rewardPoints;
	@Column(name="trans_Date")
	private Date transDate;
	@Column(name="customer_Id")
	private int customerId;
}
