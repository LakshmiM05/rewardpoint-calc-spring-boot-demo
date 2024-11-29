package com.retail.rewardpointcalc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.rewardpointcalc.entity.Customer;
import com.retail.rewardpointcalc.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByCustomerId(int customerId);

}
