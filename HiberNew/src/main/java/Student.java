import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_detail")
public class Student {
	
	@Id
	private int id;
	private String name;
	private double perc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", perc=" + perc + "]";
	}
	

}
