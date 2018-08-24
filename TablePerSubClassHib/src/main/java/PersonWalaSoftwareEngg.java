import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class PersonWalaSoftwareEngg extends Person{

	private String tool;

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
	
}
