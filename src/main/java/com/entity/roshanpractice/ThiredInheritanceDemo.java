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

public class ThiredInheritanceDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf=cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		TSEMP s1= new TSEMP(1, "AAA");
		TSPEmp s2 = new TSPEmp(2, "BBB", 2500.65);
		TSCEmp s3 = new TSCEmp(3, "CCC", 2600.56);
		se.merge(s1);
		se.merge(s2);
		se.merge(s3);
		tr.commit();
		se.close();
	}
}
@Entity
@Table(name="Third_Employee_1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class TSEMP{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="Third_emp_name")
	String Ename;
	public TSEMP(int id, String ename) {
		super();
		this.id = id;
		Ename = ename;
	}
	public TSEMP() {
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
@Table(name="Third_Permanant_Employee_1")
class TSPEmp extends TSEMP{
	@Column(name="Third_Permanant_bonus")
	double bonus;

	public TSPEmp(int id, String ename, double bonus) {
		super(id, ename);
		this.bonus = bonus;
	}

	public TSPEmp() {
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
@Table(name="Third_Contract_Employee_1")
class TSCEmp extends TSEMP{
	@Column(name="third_contract_salary")
	double salary;

	public TSCEmp(int id, String ename, double salary) {
		super(id, ename);
		this.salary = salary;
	}

	public TSCEmp() {
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