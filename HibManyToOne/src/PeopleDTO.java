import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="people_detail")
public class PeopleDTO {
	
	@Id
	private int nationalID;
	private String name;
	private String address;
	private String dateOfBirth;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="countryID")
    private CountryDTO country;
	public int getNationalID() {
		return nationalID;
	}
	public void setNationalID(int nationalID) {
		this.nationalID = nationalID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
    
    

}
