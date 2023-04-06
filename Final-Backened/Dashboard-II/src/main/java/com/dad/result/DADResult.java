package com.dad.result;

import java.util.List;

public class DADResult {
 
	 private String _id;
	    private int count;
	    private List<Customer> customers;
	    private double total_interest;

	    

	    public DADResult() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
		public DADResult(String _id, int count, List<Customer> customers, double total_interest) {
			super();
			this._id = _id;
			this.count = count;
			this.customers = customers;
			this.total_interest = total_interest;
		}

		public String get_id() {
			return _id;
		}


		public void set_id(String _id) {
			this._id = _id;
		}


		public int getCount() {
			return count;
		}


		public void setCount(int count) {
			this.count = count;
		}


		public List<Customer> getCustomers() {
			return customers;
		}


		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}


		public double getTotal_interest() {
			return total_interest;
		}


		public void setTotal_interest(double total_interest) {
			this.total_interest = total_interest;
		}



		public static class Customer {
	        private String acct_name;
	        private double normal_interest;
	          
			public Customer() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Customer(String acct_name, double normal_interest) {
				super();
				this.acct_name = acct_name;
				this.normal_interest = normal_interest;
			}

			public String getAcct_name() {
				return acct_name;
			}

			public void setAcct_name(String acct_name) {
				this.acct_name = acct_name;
			}

			public double getNormal_interest() {
				return normal_interest;
			}

			public void setNormal_interest(double normal_interest) {
				this.normal_interest = normal_interest;
			}
	        
	        
	        
	    }
	
}
