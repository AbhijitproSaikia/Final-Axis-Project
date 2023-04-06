package com.axis.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axis.dto.CountResultDto;
import com.axis.model.DashboardModel;

@Repository
public interface DashboardRepo extends MongoRepository<DashboardModel, Integer> {

	@Aggregation(pipeline = { "{ $match: { processing_status: { $eq: 'Failure' } } }",
			"{ $group: { _id: '$cbo_srm_id', count: { $sum: 1 },} }", 
			"{ $addFields: { cboSrmId: '$_id' , _id : '$$REMOVE'}}",
	})
	List<CountResultDto> getCountByCboSrmId();

}
