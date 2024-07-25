package com.entity.roshanpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
public static void main(String[] args) {
	//forBussinessLogic();
	forEmployeeData();
}
static void forBussinessLogic() {
	System.out.println("Start Programme");
	Configuration c1 = new Configuration();
	 SessionFactory sf=c1.configure("hibernate.cfg.xml").buildSessionFactory();
	 Session ss=sf.openSession();
	 Transaction tr = ss.beginTransaction();
	 BankDetails b1 = new BankDetails(354,"BOB","Paniv");
	 BankDetails b2 = new BankDetails(352,"HDFC","Akluj");
	 BankDetails b3 = new BankDetails(353,"SBI","Malshiras");
	 ss.merge(b1);
	 ss.merge(b2);
	 ss.merge(b3);
	 tr.commit();
	 ss.close();
	 System.out.println("End Programme...");
}
static void forEmployeeData() {
	System.out.println("Start Programme");
	Configuration c1 = new Configuration();
	 SessionFactory sf=c1.configure("hibernate.cfg.xml").buildSessionFactory();
	 Session ss=sf.openSession();
	 Session ss1=sf.openSession();
	 Transaction tr = ss.beginTransaction();
//	 EmployeeDetails e1 = new EmployeeDetails(1, "AAA", 25000.00,"1234567890");
//	 EmployeeDetails e2 = new EmployeeDetails(2, "BBB", 55000.00,"9874567890");
//	 EmployeeDetails e3 = new EmployeeDetails(3, "CCC", 85000.00,"1235467890");
//	 EmployeeDetails e4 = new EmployeeDetails(4, "DDD", 95000.00,"7834567890");
//	 ss.merge(e1);
//	 ss.merge(e2);
//	 ss.merge(e3);
//	 ss.merge(e4);
	 
	 EmployeeDetails emp1 = ss.load(EmployeeDetails.class, 4);
	 System.out.println("Emp1 - "+emp1);
	 EmployeeDetails emp2 = ss1.load(EmployeeDetails.class, 4);
	 System.out.println("Emp2 - "+emp2);
//	 tr.commit();
//	 ss.close();
	 System.out.println("End Programme...");
}
}
