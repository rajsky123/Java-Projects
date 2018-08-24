import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="country_detail")
public class CountryDTO {
   @Id
	private int countryID;
	private String countryName;
	private String countryCapital;
	private String language;
	@OneToMany
	@JoinColumn(name="countryID")
	private List<PeopleDTO> peoples;
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<PeopleDTO> getPeoples() {
		return peoples;
	}
	public void setPeoples(List<PeopleDTO> peoples) {
		this.peoples = peoples;
	}
	
}
