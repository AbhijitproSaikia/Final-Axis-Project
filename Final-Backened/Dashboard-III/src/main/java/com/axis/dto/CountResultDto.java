package com.axis.dto;

import java.util.List;

public class CountResultDto {

	private String solId;
	private int failureCount;
	private int blankEmailCount;
	private int totalCount;

	public CountResultDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

	public int getBlankEmailCount() {
		return blankEmailCount;
	}

	public void setBlankEmailCount(int blankEmailCount) {
		this.blankEmailCount = blankEmailCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "CountResultDto [solId=" + solId + ", failureCount=" + failureCount + ", blankEmailCount="
				+ blankEmailCount + ", totalCount=" + totalCount + "]";
	}

	
}
