import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class GetDB {

	public static void main(String[] args) {

		
	
		Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=conf.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Criteria c=session.createCriteria(Student.class);
		c.add(Restrictions.eq("name", "Name1"));
		Student l=(Student) c.uniqueResult();
		String s=l.getPassword();
		if(BCrypt.checkpw(l.getName(), s))
		{
			System.out.println("Authentic user");
		}
		tx.commit();
		session.close();
		sf.close();
		
	}

}
