package com.retail.rewardpointcalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.rewardpointcalc.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
