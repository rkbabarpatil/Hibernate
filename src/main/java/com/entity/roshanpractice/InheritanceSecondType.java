package com.entity.roshanpractice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InheritanceSecondType {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf=cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		SEMP s1= new SEMP(1, "AAA");
		SPEmp s2 = new SPEmp(2, "BBB", 2500.65);
		SCEmp s3 = new SCEmp(3, "CCC", 2600.56);
		se.merge(s1);
		se.merge(s2);
		se.merge(s3);
		tr.commit();
		se.close();
	}
}
@Entity
@Table(name="Second_Employee_1")
@Inheritance(strategy = InheritanceType.JOINED)
class SEMP{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="Second_emp_name")
	String Ename;
	public SEMP(int id, String ename) {
		super();
		this.id = id;
		Ename = ename;
	}
	public SEMP() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	@Override
	public String toString() {
		return "SEMP [id=" + id + ", Ename=" + Ename + "]";
	}
	
}
@Entity
@Table(name="Second_Permanant_Employee_1")
class SPEmp extends SEMP{
	@Column(name="Second_Permanant_bonus")
	double bonus;

	public SPEmp(int id, String ename, double bonus) {
		super(id, ename);
		this.bonus = bonus;
	}

	public SPEmp() {
		super();
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "SPEmp [bonus=" + bonus + ", id=" + id + ", Ename=" + Ename + "]";
	} 
	
}
@Entity
@Table(name="Second_Contract_Employee_1")
class SCEmp extends SEMP{
	@Column(name="Second_contract_salary")
	double salary;

	public SCEmp(int id, String ename, double salary) {
		super(id, ename);
		this.salary = salary;
	}

	public SCEmp() {
		super();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SCEmp [salary=" + salary + ", id=" + id + ", Ename=" + Ename + "]";
	}
	

}