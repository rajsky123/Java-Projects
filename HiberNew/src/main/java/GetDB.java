import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class GetDB {

	public static void main(String[] args) {

		
		Student st=null;
	
		Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class);
		//ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf=conf.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		st=(Student) session.get(Student.class,101);
		tx.commit();
		System.out.println(st);
	}

}
