package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/dashboard5")
	public ResponseEntity<List<CountResultDto>> failureAndNoEmailCaseCount() {
		return new ResponseEntity<>(service.countById(), HttpStatus.OK);
	}
	
}
