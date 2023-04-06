package com.dad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dad.repository.DADRepository;
import com.dad.result.DADResult;

@Service
public class DADService {
	
	private DADRepository dadRepository;
	
	public DADService(DADRepository dadRepository) {
		this.dadRepository=dadRepository;
	}
	
	public List<DADResult> result(){
		return dadRepository.findTotalInterestByCboSrmId();
	}
	
}
