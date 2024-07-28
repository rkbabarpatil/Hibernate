package com.entity.roshanpractice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CriteriaDemo {
	public static void main(String[] args) {
		studentRecordCall();
	}
	static void studentRecordCall() {
		System.out.println("Start Programme");
		Configuration c1 = new Configuration();
		 SessionFactory sf=c1.configure("hibernate.cfg.xml").buildSessionFactory();
		 Session ss=sf.openSession();
		 Transaction tr = ss.beginTransaction();
//		 StudentRecords s1 = new StudentRecords(1, "AAA", "Pune", 85);
//		 StudentRecords s2 = new StudentRecords(2, "BBB", "Mumbai", 75);
//		 StudentRecords s3 = new StudentRecords(3, "CCC", "nashik", 83);
//		 StudentRecords s4 = new StudentRecords(4, "DDD", "Nagpur", 95);
//		 ss.merge(s1);
//		 ss.merge(s2);
//		 ss.merge(s3);
//		 ss.merge(s4);
//		 tr.commit();
		 Criteria crs = ss.createCriteria(StudentRecords.class);
		 List std = crs.list();
		 System.out.println("Info - "+std);
		 ss.close();
		 System.out.println("End...");
	}
}
@Entity
@Table(name="student_records")
class StudentRecords{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int sid;
	
	@Column(name="Student_name")
	String sname;
	
	@Column(name="address")
	String saddress;
	
	@Column(name="student_marks")
	int marks;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentRecords [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", marks=" + marks + "]\n";
	}

	public StudentRecords(int sid, String sname, String saddress, int marks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddress = saddress;
		this.marks = marks;
	}

	public StudentRecords() {
		super();
	}
	
}