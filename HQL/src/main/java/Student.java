import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="new_student")
public class Student {
	
	@Id
	@Column(name="stud_id")
	private int id;
	private String name;
	private String password;
	private double perc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", perc=" + perc + "]";
	}
	
	

}
