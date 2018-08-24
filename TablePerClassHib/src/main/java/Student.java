import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student extends Person{
	
	private double perc;

	public double getPerc() {
		return perc;
	}

	public void setPerc(double perc) {
		this.perc = perc;
	}
	

}
