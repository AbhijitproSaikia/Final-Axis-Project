package com.dad.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dad.model.DAD;
import com.dad.result.DADResult;


@Repository
public interface DADRepository extends MongoRepository<DAD, Integer> {
	
//	@Aggregation("{ $group: { _id: '$cbo_srm_id', total_interest: { $sum: '$normal_interest' },count: {$sum: 1} } }")
	
	@Aggregation ("{ $group: { _id: '$cbo_srm_id', total_interest: { $sum: '$normal_interest' },count: {$sum: 1}, customers: { $push: { acct_name: '$acct_name', normal_interest: '$normal_interest' } } } }")
	List<DADResult> findTotalInterestByCboSrmId();

}
