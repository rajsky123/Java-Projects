import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class PersonWalaStudent extends Person{
	
	private double perc;

	public double getPerc() {
		return perc;
	}

	public void setPerc(double perc) {
		this.perc = perc;
	}
	

}
