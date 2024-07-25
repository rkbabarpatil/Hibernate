package com.entity.roshanpractice;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Emp_Details")
@Cacheable  
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) 
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	int eid;
	
	@NotNull
	@Column(name="emp_name")
	String ename;
	
	@Column(name="salary")
	double salary;
	
	@Length(min = 1,max = 10)
	@Column(name="mobile_no")
	String mobileNO;
	
	@Column(name="deleted",columnDefinition = "varchar(2) Default 'N'")
	String deleted="N";

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public EmployeeDetails(int eid, String ename, double salary, String mobileNO) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.mobileNO = mobileNO;
	}

	public EmployeeDetails() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeDetails [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", mobileNO=" + mobileNO
				+ ", deleted=" + deleted + "]";
	}
	
	
}
