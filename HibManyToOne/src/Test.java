import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		CountryDTO country=new CountryDTO();
		country.setCountryID(1);
		country.setCountryName("India");
		country.setCountryCapital("Delhi");
		country.setLanguage("Hindi");
			PeopleDTO people1=new PeopleDTO();
			people1.setNationalID(123);
			people1.setName("Rahul");
			people1.setDateOfBirth("25-12-1990");
			people1.setAddress("Mumbai");
			people1.setCountry(country);
			PeopleDTO people2=new PeopleDTO();
			people2.setNationalID(124);
			people2.setName("Raj");
			people2.setDateOfBirth("22-02-1950");
			people2.setAddress("Bangalore");
			people2.setCountry(country);
		List<PeopleDTO> people=new ArrayList<>();
		people.add(people1);
		people.add(people2);
		country.setPeoples(people);
		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(CountryDTO.class).addAnnotatedClass(PeopleDTO.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(people1);
		session.save(people2);
		tx.commit();
	}

}
