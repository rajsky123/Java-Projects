import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class PushDB {

	public static void main(String[] args) {

		
	
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
	   
		PersonWalaStudent st=new PersonWalaStudent();
		st.setName("jagdev");
		st.setPerc(99.0);
		session.save(st);
		
		PersonWalaSoftwareEngg sft=new PersonWalaSoftwareEngg();
		sft.setName("biswa");
		sft.setTool("hibernate");
		session.save(sft);
		tx.commit();
		session.close();
		sf.close();
		
	}

}
