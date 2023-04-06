package com.dad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "loan")
public class DAD {
	
	private int sr_no;
	private String sol_id;
	private String acct_name;
	private String schm_code;
	private String principal_payment_due_date;
	private double principal_payment_amount;
	private String interest_payment_due_date;
	private String primary_manager_id;
	private String secondary_manager_id;
	private String tertiary_manager_id;
	private String cbo_srm_id;
	private String credit_admin_manager_id;
	private double normal_interest;
	private String interest_calc_status;
	private double penal_interest;
	private String penal_calc_status;
	private String processing_status;
	
	public DAD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DAD(int sr_no, String sol_id, String acct_name, String schm_code, String principal_payment_due_date,
			double principal_payment_amount, String interest_payment_due_date, String primary_manager_id,
			String secondary_manager_id, String tertiary_manager_id, String cbo_srm_id, String credit_admin_manager_id,
			double normal_interest, String interest_calc_status, double penal_interest, String penal_calc_status,
			String processing_status) {
		super();
		this.sr_no = sr_no;
		this.sol_id = sol_id;
		this.acct_name = acct_name;
		this.schm_code = schm_code;
		this.principal_payment_due_date = principal_payment_due_date;
		this.principal_payment_amount = principal_payment_amount;
		this.interest_payment_due_date = interest_payment_due_date;
		this.primary_manager_id = primary_manager_id;
		this.secondary_manager_id = secondary_manager_id;
		this.tertiary_manager_id = tertiary_manager_id;
		this.cbo_srm_id = cbo_srm_id;
		this.credit_admin_manager_id = credit_admin_manager_id;
		this.normal_interest = normal_interest;
		this.interest_calc_status = interest_calc_status;
		this.penal_interest = penal_interest;
		this.penal_calc_status = penal_calc_status;
		this.processing_status = processing_status;
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public String getSol_id() {
		return sol_id;
	}

	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getSchm_code() {
		return schm_code;
	}

	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}

	public String getPrincipal_payment_due_date() {
		return principal_payment_due_date;
	}

	public void setPrincipal_payment_due_date(String principal_payment_due_date) {
		this.principal_payment_due_date = principal_payment_due_date;
	}

	public double getPrincipal_payment_amount() {
		return principal_payment_amount;
	}

	public void setPrincipal_payment_amount(double principal_payment_amount) {
		this.principal_payment_amount = principal_payment_amount;
	}

	public String getInterest_payment_due_date() {
		return interest_payment_due_date;
	}

	public void setInterest_payment_due_date(String interest_payment_due_date) {
		this.interest_payment_due_date = interest_payment_due_date;
	}

	public String getPrimary_manager_id() {
		return primary_manager_id;
	}

	public void setPrimary_manager_id(String primary_manager_id) {
		this.primary_manager_id = primary_manager_id;
	}

	public String getSecondary_manager_id() {
		return secondary_manager_id;
	}

	public void setSecondary_manager_id(String secondary_manager_id) {
		this.secondary_manager_id = secondary_manager_id;
	}

	public String getTertiary_manager_id() {
		return tertiary_manager_id;
	}

	public void setTertiary_manager_id(String tertiary_manager_id) {
		this.tertiary_manager_id = tertiary_manager_id;
	}

	public String getCbo_srm_id() {
		return cbo_srm_id;
	}

	public void setCbo_srm_id(String cbo_srm_id) {
		this.cbo_srm_id = cbo_srm_id;
	}

	public String getCredit_admin_manager_id() {
		return credit_admin_manager_id;
	}

	public void setCredit_admin_manager_id(String credit_admin_manager_id) {
		this.credit_admin_manager_id = credit_admin_manager_id;
	}

	public double getNormal_interest() {
		return normal_interest;
	}

	public void setNormal_interest(double normal_interest) {
		this.normal_interest = normal_interest;
	}

	public String getInterest_calc_status() {
		return interest_calc_status;
	}

	public void setInterest_calc_status(String interest_calc_status) {
		this.interest_calc_status = interest_calc_status;
	}

	public double getPenal_interest() {
		return penal_interest;
	}

	public void setPenal_interest(double penal_interest) {
		this.penal_interest = penal_interest;
	}

	public String getPenal_calc_status() {
		return penal_calc_status;
	}

	public void setPenal_calc_status(String penal_calc_status) {
		this.penal_calc_status = penal_calc_status;
	}

	public String getProcessing_status() {
		return processing_status;
	}

	public void setProcessing_status(String processing_status) {
		this.processing_status = processing_status;
	}
	
}
