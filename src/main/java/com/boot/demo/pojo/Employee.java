package com.boot.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int eid;
	private String ename;
	private String eemail;
	private String edpt;
	
	public Employee() {
		
	}
	
	public Employee(int eid, String ename, String eemail, String edpt) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eemail = eemail;
		this.edpt = edpt;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEdpt() {
		return edpt;
	}

	public void setEdpt(String edpt) {
		this.edpt = edpt;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eemail=" + eemail + ", edpt=" + edpt + "]";
	}

}
