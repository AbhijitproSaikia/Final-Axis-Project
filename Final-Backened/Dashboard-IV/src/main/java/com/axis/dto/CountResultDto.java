package com.axis.dto;

import java.util.List;

public class CountResultDto {

	private String cboSrmId;
    private int count;
    
    
	public CountResultDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCboSrmId() {
		return cboSrmId;
	}

	public void setCboSrmId(String cboSrmId) {
		this.cboSrmId = cboSrmId;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CountResultDto [cboSrmId=" + cboSrmId + ", count=" + count + "]";
	}
	
}
