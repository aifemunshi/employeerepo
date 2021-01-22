package sample.multimodule.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Aife Munshi
 *
 */
@Entity
@Table(name="T_EMPLOYEE_DETAILS")
public class Employee{

	@Id
    @Column(name="user_id")
    private String id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="mailid")
    private String maidId;
    
    @Column(name="gender")
    private String gender;
    
    @Column(name="age")
    private Integer age;
    
    @Column(name="address")
    private String address;
    
    
    //Default constructor for deserialisation
    public Employee(){}


	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param maidId
	 * @param gender
	 * @param age
	 * @param address
	 */
	public Employee(String id, String firstName, String lastName, String maidId, String gender, Integer age,
			String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maidId = maidId;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the maidId
	 */
	public String getMaidId() {
		return maidId;
	}


	/**
	 * @param maidId the maidId to set
	 */
	public void setMaidId(String maidId) {
		this.maidId = maidId;
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
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
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
