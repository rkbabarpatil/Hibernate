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

public class InheritanceDemo {
	public static void main(String[] args) {
		mainDemo();
	}
	static void mainDemo() {
		try {
			Configuration cfg = new Configuration();
			SessionFactory sf=cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			Session se=sf.openSession();
			Transaction tr=se.beginTransaction();
			Emp e1 = new Emp(1, "Roshan", "Patil");
			PEmp p1 = new PEmp(2, "Kumar", "Babar", 2500.25);
			CEmp c1 = new CEmp(3, "Aaradhya", "patil", 5656220.12);
			se.merge(e1);
			se.merge(p1);
			se.merge(c1);
			tr.commit();
			se.close();
			System.out.println("Inserted...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

@Entity
@Table(name="Employee_Details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Emp{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="first_name")
	String fName;
	
	@Column(name="last_name")
	String lName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Emp(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	public Emp() {
		super();
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
}
@Entity
class PEmp extends Emp{
	
	@Column(name="pf_balance")
	double Pf;

	public PEmp(int id, String fName, String lName, double pf) {
		super(id, fName, lName);
		Pf = pf;
	}
	
	
	public PEmp() {
		
	}


	public double getPf() {
		return Pf;
	}

	public void setPf(double pf) {
		Pf = pf;
	}

	@Override
	public String toString() {
		return "PEmp [Pf=" + Pf + ", id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}

	
}
@Entity
class CEmp extends Emp{
	@Column(name="salary")
	double salary;

	public CEmp(int id, String fName, String lName, double salary) {
		super(id, fName, lName);
		this.salary = salary;
	}

	public CEmp() {
		
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "CEmp [salary=" + salary + ", id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
}