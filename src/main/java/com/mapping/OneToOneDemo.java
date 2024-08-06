package com.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
public static void main(String[] args) {
	 oneDemo();
}
static void oneDemo() {
	Configuration cfg = new Configuration();
	SessionFactory sf=cfg.configure("hibernate.cfg.xml").buildSessionFactory();
	Session se=sf.openSession();
	Transaction tr=se.beginTransaction();
	Aadhar a1 = new Aadhar(1, "124598653214");
	Aadhar a2 = new Aadhar(2, "789645123654");
	Person p1 = new Person(1, "AAA", a1);
	Person p2 = new Person(2, "BBB", a2);
	
	se.merge(p1);
	se.merge(p2);
//	Person per = se.get(Person.class, 1);
//	System.out.println("Details - "+per);
	tr.commit();
	se.close();
}
}
@Entity
@Table(name="aadhar_info")
class Aadhar{
	@Id
	int id;
	
	@Column(name="aadhar_namber")
	String aadharNumber;

	public Aadhar(int id, String aadharNumber) {
		super();
		this.id = id;
		this.aadharNumber = aadharNumber;
	}

	public Aadhar() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Override
	public String toString() {
		return "Aadhar [id=" + id + ", aadharNumber=" + aadharNumber + "]";
	}
	
}
@Entity
@Table(name="person_info")
class Person{
	@Id
	int id;
	
	@Column(name="person_name")
	String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="aadhar_id")
	Aadhar a1;

	public Person(int id, String name, Aadhar a1) {
		super();
		this.id = id;
		this.name = name;
		this.a1 = a1;
	}

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Aadhar getA1() {
		return a1;
	}

	public void setA1(Aadhar a1) {
		this.a1 = a1;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", a1=" + a1 + "]";
	}
	
}