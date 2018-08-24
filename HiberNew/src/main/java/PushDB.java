
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class PushDB {

	public static void main(String[] args) {

		Student st=new Student();
		st.setId(1032);
		st.setName("rajiv");
		st.setPerc(99.21);
		
		Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=conf.buildSessionFactory();
		
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(st);
		tx.commit();
		
		
		
	}

}
