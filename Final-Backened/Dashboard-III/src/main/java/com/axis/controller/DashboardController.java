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
import com.axis.kafka.Producer;
import com.axis.service.DashBoardService;

@RestController
@RequestMapping("/datapilot")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

	@Autowired
	private DashBoardService service;
	
	@Autowired
    private KafkaTemplate<String, CountResultDto> kafkaTemplate;

	@GetMapping("/dashboard3")
	public ResponseEntity<List<CountResultDto>> failureAndNoEmailCaseCount() {
		
		List<CountResultDto> results = service.countById();
		for(CountResultDto result : results) {
			kafkaTemplate.send("DashBoard3", result);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

}
