
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PushDB {

	public static void main(String[] args) {

		Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=conf.buildSessionFactory();
		
		Session session=sf.openSession();
		session.beginTransaction();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Random r=new Random();
     for(int i=0;i<50;i++)
     {
    	 Student st=new Student();
    	 st.setId(i);
    	 st.setName("Name"+i);
    	 st.setPassword(encoder.encode("Name"+i));
    	 st.setPerc(r.nextInt(100));
    	 session.save(st);
     }
     
     session.getTransaction().commit();
		
		
		
		
	}

}
