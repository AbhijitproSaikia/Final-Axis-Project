package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.CountResultDto;
import com.axis.service.DashBoardService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/datapilot")
public class DashboardController {

	@Autowired
	private DashBoardService service;
	@Autowired
    private KafkaTemplate<String, CountResultDto> kafkaTemplate;
	
	@GetMapping("/dashboard6")
	public ResponseEntity<List<CountResultDto>> failureCaseCount() {
		List<CountResultDto> results = service.goodCustomers();
		for(CountResultDto result : results) {
			kafkaTemplate.send("DashBoard6", result);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
	
}
