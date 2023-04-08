package com.dad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dad.result.DADResult;
import com.dad.service.DADService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dash1")
public class DADController {

	@Autowired
	private DADService dadService;
	
	@Autowired
	private KafkaTemplate<String, DADResult> kafkaTemplate;
	
	@GetMapping("/cbo")
	public ResponseEntity<List<DADResult>> cbo(){
		
		List<DADResult> results = dadService.result();
		for(DADResult result : results) {
			kafkaTemplate.send("DashBoard1", result);
		}
		
		return new ResponseEntity<>(results,HttpStatus.OK);
	}
}
