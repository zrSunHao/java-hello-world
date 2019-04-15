package com.sun.helloworld.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class business_revoke_companyinfo_temp {

	@TableId
	public Long id;

	public String collecter_no;

	public String collecter_name;

	public String contract_flag;

	public String account_name;

	public String account_no;

	public String deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollecter_no() {
		return collecter_no;
	}

	public void setCollecter_no(String collecter_no) {
		this.collecter_no = collecter_no;
	}

	public String getCollecter_name() {
		return collecter_name;
	}

	public void setCollecter_name(String collecter_name) {
		this.collecter_name = collecter_name;
	}

	public String getContract_flag() {
		return contract_flag;
	}

	public void setContract_flag(String contract_flag) {
		this.contract_flag = contract_flag;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

}
