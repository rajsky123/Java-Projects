package com.hib.java;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDBox {
 
	public static void main(String[] args) {
	
	int id;	
	String nm;
	double marks;
	Student st=new Student();
	Scanner sc=new Scanner(System.in);
	SessionFactory sf=HibConfig.getSessionFactory();
	Session session=sf.openSession();
	Transaction tx;
	
	
	while(true) {
		System.out.println("Press 1 to insert a record");
		System.out.println("Press 2 to read a record");
		System.out.println("Press 3 to update a record");
		System.out.println("Press 4 to delete a record");
		System.out.println("Press 5 to exit");
		
		int n=sc.nextInt();
		if(n==5)
			break;
		
		switch (n) {
					case 1:tx=session.beginTransaction();
					       System.out.println("Enter student name:");
						   nm=sc.next();
					       st.setName(nm);
					       System.out.println("Enter student marks:");
					       marks=sc.nextDouble();
					       st.setPerc(marks);
					       session.save(st);
					       tx.commit();
						   System.out.println(st);
						break;
						
					case 2:
						   System.out.println("Enter student id to display his/her record");
						   id=sc.nextInt();
						   st=session.get(Student.class, id);	
						   System.out.println(st);
						   break;
			
					case 3:tx=session.beginTransaction();
						   System.out.println("press 1 to update student name");
						   System.out.println("press 2 to update student marks");
						   System.out.println("press 3 to update student name and marks");
						   int nn=sc.nextInt();
						   switch (nn) {
									    case 1:System.out.println("Enter student id");
									    		id=sc.nextInt();
									    		st=session.get(Student.class, id);
									    		System.out.println("Enter student name");
									            nm=sc.next();
									            st.setName(nm);
									    		session.update(st);
									    		tx.commit();
									         	break;
										
									    case 2:System.out.println("Enter student id");
									    		id=sc.nextInt();
									    		st=session.get(Student.class, id);
									    		System.out.println("Enter student marks");
									            marks=sc.nextDouble();
									            st.setPerc(marks);
									    		session.update(st);
									    		tx.commit();
									    		break;
						
									    case 3:System.out.println("Enter student id");
									    		id=sc.nextInt();
									    		st=session.get(Student.class, id);
									    		System.out.println("Enter student name");
									    		nm=sc.next();
									    		st.setName(nm);
									    		System.out.println("Enter student marks");
									            marks=sc.nextDouble();
									            st.setPerc(marks);
									    		session.update(st);
									    		tx.commit();
									    		break;
							    		
									    default:System.out.println("Invalid option");
										break;
						   		} break;
						   
						   
					case 4: tx=session.beginTransaction();
						    System.out.println("Enter student id to delete");
				          	id=sc.nextInt();
				          	st=session.get(Student.class, id);
				          	session.delete(st);
				          	tx.commit();
				          	break;
					default:System.out.println("Invalid option");
						break;
		}
		
	}
	sc.close();
	session.close();
	}
}
