package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CountResultDto;
import com.axis.repo.DashboardRepo;

@Service
public class DashBoardService {
	
	@Autowired
	private DashboardRepo repo;
	
	public List<CountResultDto> countById() {
		return repo.getCountByCboSrmId();
	}
	
	
	
}
