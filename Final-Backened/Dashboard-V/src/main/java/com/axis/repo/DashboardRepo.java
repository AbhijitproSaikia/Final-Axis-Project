package com.axis.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axis.dto.CountResultDto;
import com.axis.model.DashboardModel;

@Repository
public interface DashboardRepo extends MongoRepository<DashboardModel, Integer> {

	@Aggregation(pipeline = 
		{ 
			"{$match: {processing_status: 'Cust_Email_Is_Blank'} }",
			"{$group: {_id: '$cbo_srm_id', count: {$sum: 1}, customers: { $push: { name: '$acct_name', normalInterest: '$normal_interest' } }}}",
			"{ $addFields: { cboSrmId: '$_id' , _id : '$$REMOVE'}}"
		})
	List<CountResultDto> getCountByCboSrmId();

}
