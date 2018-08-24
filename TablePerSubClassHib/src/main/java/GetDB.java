import org.hibernate.Session;

public class GetDB {

	public static void main(String[] args) {
		
	
	
	Session session=HibernateUtil.getSessionFactory().openSession();
	
	Person p=(Person) session.load(Person.class, 48);
	
	System.out.println(p.getName());
}
}