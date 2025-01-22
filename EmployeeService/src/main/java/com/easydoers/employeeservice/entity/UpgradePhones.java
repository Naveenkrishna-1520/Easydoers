package com.easydoers.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class UpgradePhones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "invoice_id", nullable = false)
	private UpgradePhonesInvoice invoice;
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	private String imei;
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private UpgradePhonesSale soldInfo;
	@OneToOne
	@JoinColumn(name = "transfer_id")
	private UpgradePhoneTransfer transfer;
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	/**
	 * 
	 */
	public UpgradePhones() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param invoice
	 * @param product
	 * @param imei
	 * @param phoneNumber
	 * @param soldInfo
	 * @param transfer
	 * @param store
	 */
	public UpgradePhones(Long id, UpgradePhonesInvoice invoice, Product product, String imei, String phoneNumber,
			UpgradePhonesSale soldInfo, UpgradePhoneTransfer transfer, Store store) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.imei = imei;
		this.phoneNumber = phoneNumber;
		this.soldInfo = soldInfo;
		this.transfer = transfer;
		this.store = store;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the invoice
	 */
	public UpgradePhonesInvoice getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(UpgradePhonesInvoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the soldInfo
	 */
	public UpgradePhonesSale getSoldInfo() {
		return soldInfo;
	}

	/**
	 * @param soldInfo the soldInfo to set
	 */
	public void setSoldInfo(UpgradePhonesSale soldInfo) {
		this.soldInfo = soldInfo;
	}

	/**
	 * @return the transfer
	 */
	public UpgradePhoneTransfer getTransfer() {
		return transfer;
	}

	/**
	 * @param transfer the transfer to set
	 */
	public void setTransfer(UpgradePhoneTransfer transfer) {
		this.transfer = transfer;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}

}
