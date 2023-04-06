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
            "{ $match: { processing_status: { $in: ['Failure', 'Cust_Email_Is_Blank'] } } }",
            "{ $group: { _id: '$sol_id',"
                    +"failureCount: { $sum: { $cond: [{ $eq: ['$processing_status', 'Failure'] }, 1, 0] }},"
                    +"blankEmailCount: { $sum: { $cond: [{ $eq: ['$processing_status', 'Cust_Email_Is_Blank'] }, 1, 0] }}}}",
            "{ $addFields: { totalCount: { $add: ['$failureCount', '$blankEmailCount'] }, solId: '$_id' , _id: '$$REMOVE'}}"
    })
    List<CountResultDto> getCountBySolId();
}
