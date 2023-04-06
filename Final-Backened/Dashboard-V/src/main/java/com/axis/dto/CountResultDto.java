package com.axis.dto;

import java.util.List;

public class CountResultDto {

	private String cboSrmId;
	private int count;
	private List<Customers> customers;
	
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

	public List<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	
	public static class Customers {
		private String name;
		private Double normalInterest;
		public Customers() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getNormalInterest() {
			return normalInterest;
		}
		public void setNormalInterest(Double normalInterest) {
			this.normalInterest = normalInterest;
		}
		
	}

}
