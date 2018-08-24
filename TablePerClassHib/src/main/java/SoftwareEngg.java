import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("softwareengg")
public class SoftwareEngg extends Person{

	private String tool;

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
	
}
