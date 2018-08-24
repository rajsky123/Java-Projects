import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class PushDB {

	public static void main(String[] args) {

		
	
		Configuration conf=new Configuration().configure();
		conf.addAnnotatedClass(Person.class);
		conf.addAnnotatedClass(Student.class);
		conf.addAnnotatedClass(SoftwareEngg.class);
		SessionFactory sf=conf.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Student st=new Student();
		st.setId(1);
		st.setName("jagdev");
		st.setPerc(99.0);
		session.save(st);
		
		SoftwareEngg sft=new SoftwareEngg();
		sft.setId(2);
		sft.setName("biswa");
		sft.setTool("hibernate");
		session.save(sft);
		tx.commit();
		session.close();
		sf.close();
		
	}

}
