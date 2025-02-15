package com.easydoers.employeeservice.dto;

import java.time.LocalDate;

public class SaleHistoryDTO {

	private Long saleId;
	private String employeeName;
	private int boxesSold;
	private double systemAccessories;
	private double accessories;
	private int tabletsSold;
	private int hsiSold;
	private int watchesSold;
	private double systemCash;
	private double systemCard;
	private double actualCash;
	private double actualCard;
	private double cashExpense;
	private String expenseReason;
	private LocalDate saleDate;

	/**
	 * 
	 */
	public SaleHistoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param saleId
	 * @param employeeName
	 * @param boxesSold
	 * @param systemAccessories
	 * @param accessories
	 * @param tabletsSold
	 * @param hsiSold
	 * @param watchesSold
	 * @param systemCash
	 * @param systemCard
	 * @param actualCash
	 * @param actualCard
	 * @param cashExpense
	 * @param expenseReason
	 * @param saleDate
	 */
	public SaleHistoryDTO(Long saleId, String employeeName, int boxesSold, double systemAccessories, double accessories,
			int tabletsSold, int hsiSold, int watchesSold, double systemCash, double systemCard, double actualCash,
			double actualCard, double cashExpense, String expenseReason, LocalDate saleDate) {
		super();
		this.saleId = saleId;
		this.employeeName = employeeName;
		this.boxesSold = boxesSold;
		this.systemAccessories = systemAccessories;
		this.accessories = accessories;
		this.tabletsSold = tabletsSold;
		this.hsiSold = hsiSold;
		this.watchesSold = watchesSold;
		this.systemCash = systemCash;
		this.systemCard = systemCard;
		this.actualCash = actualCash;
		this.actualCard = actualCard;
		this.cashExpense = cashExpense;
		this.expenseReason = expenseReason;
		this.saleDate = saleDate;
	}

	/**
	 * @return the saleId
	 */
	public Long getSaleId() {
		return saleId;
	}

	/**
	 * @param saleId the saleId to set
	 */
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
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
	 * @return the boxesSold
	 */
	public int getBoxesSold() {
		return boxesSold;
	}

	/**
	 * @param boxesSold the boxesSold to set
	 */
	public void setBoxesSold(int boxesSold) {
		this.boxesSold = boxesSold;
	}

	/**
	 * @return the systemAccessories
	 */
	public double getSystemAccessories() {
		return systemAccessories;
	}

	/**
	 * @param systemAccessories the systemAccessories to set
	 */
	public void setSystemAccessories(double systemAccessories) {
		this.systemAccessories = systemAccessories;
	}

	/**
	 * @return the accessories
	 */
	public double getAccessories() {
		return accessories;
	}

	/**
	 * @param accessories the accessories to set
	 */
	public void setAccessories(double accessories) {
		this.accessories = accessories;
	}

	/**
	 * @return the tabletsSold
	 */
	public int getTabletsSold() {
		return tabletsSold;
	}

	/**
	 * @param tabletsSold the tabletsSold to set
	 */
	public void setTabletsSold(int tabletsSold) {
		this.tabletsSold = tabletsSold;
	}

	/**
	 * @return the hsiSold
	 */
	public int getHsiSold() {
		return hsiSold;
	}

	/**
	 * @param hsiSold the hsiSold to set
	 */
	public void setHsiSold(int hsiSold) {
		this.hsiSold = hsiSold;
	}

	/**
	 * @return the watchesSold
	 */
	public int getWatchesSold() {
		return watchesSold;
	}

	/**
	 * @param watchesSold the watchesSold to set
	 */
	public void setWatchesSold(int watchesSold) {
		this.watchesSold = watchesSold;
	}

	/**
	 * @return the systemCash
	 */
	public double getSystemCash() {
		return systemCash;
	}

	/**
	 * @param systemCash the systemCash to set
	 */
	public void setSystemCash(double systemCash) {
		this.systemCash = systemCash;
	}

	/**
	 * @return the systemCard
	 */
	public double getSystemCard() {
		return systemCard;
	}

	/**
	 * @param systemCard the systemCard to set
	 */
	public void setSystemCard(double systemCard) {
		this.systemCard = systemCard;
	}

	/**
	 * @return the actualCash
	 */
	public double getActualCash() {
		return actualCash;
	}

	/**
	 * @param actualCash the actualCash to set
	 */
	public void setActualCash(double actualCash) {
		this.actualCash = actualCash;
	}

	/**
	 * @return the actualCard
	 */
	public double getActualCard() {
		return actualCard;
	}

	/**
	 * @param actualCard the actualCard to set
	 */
	public void setActualCard(double actualCard) {
		this.actualCard = actualCard;
	}

	/**
	 * @return the cashExpense
	 */
	public double getCashExpense() {
		return cashExpense;
	}

	/**
	 * @param cashExpense the cashExpense to set
	 */
	public void setCashExpense(double cashExpense) {
		this.cashExpense = cashExpense;
	}

	/**
	 * @return the expenseReason
	 */
	public String getExpenseReason() {
		return expenseReason;
	}

	/**
	 * @param expenseReason the expenseReason to set
	 */
	public void setExpenseReason(String expenseReason) {
		this.expenseReason = expenseReason;
	}

	/**
	 * @return the saleDate
	 */
	public LocalDate getSaleDate() {
		return saleDate;
	}

	/**
	 * @param saleDate the saleDate to set
	 */
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

}
