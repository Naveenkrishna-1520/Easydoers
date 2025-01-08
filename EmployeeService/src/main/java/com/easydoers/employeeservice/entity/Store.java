package com.easydoers.employeeservice.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	private String dealerStoreId;
	private String storeName;
	@OneToOne
	private Address address;;
	private Long storeContactNumber;
	@ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


	/**
	 * 
	 */
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param storeId
	 * @param dealerStoreId
	 * @param storeName
	 * @param address
	 * @param storeContactNumber
	 * @param company
	 */
	public Store(Long storeId, String dealerStoreId, String storeName, Address address, Long storeContactNumber,
			Company company) {
		super();
		this.storeId = storeId;
		this.dealerStoreId = dealerStoreId;
		this.storeName = storeName;
		this.address = address;
		this.storeContactNumber = storeContactNumber;
		this.company = company;
	}


	/**
	 * @return the storeId
	 */
	public Long getStoreId() {
		return storeId;
	}


	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}


	/**
	 * @return the dealerStoreId
	 */
	public String getDealerStoreId() {
		return dealerStoreId;
	}


	/**
	 * @param dealerStoreId the dealerStoreId to set
	 */
	public void setDealerStoreId(String dealerStoreId) {
		this.dealerStoreId = dealerStoreId;
	}


	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}


	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	 * @return the storeContactNumber
	 */
	public Long getStoreContactNumber() {
		return storeContactNumber;
	}


	/**
	 * @param storeContactNumber the storeContactNumber to set
	 */
	public void setStoreContactNumber(Long storeContactNumber) {
		this.storeContactNumber = storeContactNumber;
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


	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", dealerStoreId=" + dealerStoreId + ", storeName=" + storeName
				+ ", address=" + address + ", storeContactNumber=" + storeContactNumber + ", company=" + company + "]";
	}

	
}
