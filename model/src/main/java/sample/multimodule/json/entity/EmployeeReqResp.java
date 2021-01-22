/**
 * 
 */
package sample.multimodule.json.entity;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author Aife Munshi
 *
 */
public class EmployeeReqResp {
	
	@NotNull(message = "Please provide a employee id")
	private String empId;
	
	@NotNull(message = "Please provide a first name")
	private String firstName;
	
	@NotNull(message = "Please provide a last name")
	private String lastName;
	
	@NotNull(message = "Please provide a mail id")
	private String mailId;
	
	@NotNull(message = "Please provide age")
	private String age;
	
	@NotNull(message = "Please provide gender")
	private String gender;
	
	@NotNull(message = "Please provide address")
	private String address;
	
	//Default constructor for deserialization
	public EmployeeReqResp(){}

	/**
	 * @param empId
	 * @param firstName
	 * @param lastName
	 * @param mailId
	 * @param age
	 * @param gender
	 * @param address
	 */
	public EmployeeReqResp(String empId, String firstName, String lastName, String mailId, String age, String gender,
			String address) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}



	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}



	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the mailId
	 */
	public String getMailId() {
		return mailId;
	}



	/**
	 * @param mailId the mailId to set
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}



	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}



	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}



	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}



	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
