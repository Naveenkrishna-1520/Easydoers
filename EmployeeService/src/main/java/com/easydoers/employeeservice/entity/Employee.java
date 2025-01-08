package com.easydoers.employeeservice.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String employeeNtid;
	private String employeeName;
	private Long phoneNumber;
	private String email;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	private int employeePayRatePerHour;
	private int commissionPercentage;

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeId
	 * @param employeeNtid
	 * @param employeeName
	 * @param phoneNumber
	 * @param email
	 * @param company
	 * @param address
	 * @param employeePayRatePerHour
	 * @param commissionPercentage
	 */
	public Employee(Long employeeId, String employeeNtid, String employeeName, Long phoneNumber, String email,
			Company company, Address address, int employeePayRatePerHour, int commissionPercentage) {
		super();
		this.employeeId = employeeId;
		this.employeeNtid = employeeNtid;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.company = company;
		this.address = address;
		this.employeePayRatePerHour = employeePayRatePerHour;
		this.commissionPercentage = commissionPercentage;
	}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeNtid
	 */
	public String getEmployeeNtid() {
		return employeeNtid;
	}

	/**
	 * @param employeeNtid the employeeNtid to set
	 */
	public void setEmployeeNtid(String employeeNtid) {
		this.employeeNtid = employeeNtid;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the employeePayRatePerHour
	 */
	public int getEmployeePayRatePerHour() {
		return employeePayRatePerHour;
	}

	/**
	 * @param employeePayRatePerHour the employeePayRatePerHour to set
	 */
	public void setEmployeePayRatePerHour(int employeePayRatePerHour) {
		this.employeePayRatePerHour = employeePayRatePerHour;
	}

	/**
	 * @return the commissionPercentage
	 */
	public int getCommissionPercentage() {
		return commissionPercentage;
	}

	/**
	 * @param commissionPercentage the commissionPercentage to set
	 */
	public void setCommissionPercentage(int commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeNtid=" + employeeNtid + ", employeeName="
				+ employeeName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", company=" + company
				+ ", address=" + address + ", employeePayRatePerHour=" + employeePayRatePerHour
				+ ", commissionPercentage=" + commissionPercentage + "]";
	}

	
}
