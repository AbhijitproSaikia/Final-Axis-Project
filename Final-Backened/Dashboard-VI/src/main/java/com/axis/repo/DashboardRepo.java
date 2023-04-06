package com.axis.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axis.dto.CountResultDto;
import com.axis.model.DashboardModel;

@Repository
public interface DashboardRepo extends MongoRepository<DashboardModel, Integer> {

	@Aggregation(pipeline = {
			"{ $match: { $or: [ { principal_payment_due_date: { $eq: null } }, { normal_interest: { $eq: 0 } }, { normal_interest: { $eq: null } } ] } }",
			"{ $group: { _id: '$cbo_srm_id', count: { $sum: 1 },"
			+ "  customers: {"
			+ "    $push: {"
			+ "      name: '$acct_name',"
			+ "      principalPaymentDueDate: {"
			+ "        $ifNull: ['$principal_payment_due_date','Empty']},"
			+ "      normalInterest: {"
			+ "        $ifNull: ['$normal_interest', '0']}}},} }",
			"{ $addFields: { cboSrmId: '$_id' , _id : '$$REMOVE'}}",
	})
	List<CountResultDto> goodCustomers();

}
