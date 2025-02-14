package com.easydoers.employeeservice.dto;

public class CashDTO {

	private double systemCash;
	private double actualCash;
	private double systemCard;
	private double actualCard;
	private double systemAccessories;
	private double cashAccessories;
	private double cardAccessories;

	/**
	 * 
	 */
	public CashDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param systemCash
	 * @param actualCash
	 * @param systemCard
	 * @param actualCard
	 * @param systemAccessories
	 * @param cashAccessories
	 * @param cardAccessories
	 */
	public CashDTO(double systemCash, double actualCash, double systemCard, double actualCard, double systemAccessories,
			double cashAccessories, double cardAccessories) {
		super();
		this.systemCash = systemCash;
		this.actualCash = actualCash;
		this.systemCard = systemCard;
		this.actualCard = actualCard;
		this.systemAccessories = systemAccessories;
		this.cashAccessories = cashAccessories;
		this.cardAccessories = cardAccessories;
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
	 * @return the cashAccessories
	 */
	public double getCashAccessories() {
		return cashAccessories;
	}

	/**
	 * @param cashAccessories the cashAccessories to set
	 */
	public void setCashAccessories(double cashAccessories) {
		this.cashAccessories = cashAccessories;
	}

	/**
	 * @return the cardAccessories
	 */
	public double getCardAccessories() {
		return cardAccessories;
	}

	/**
	 * @param cardAccessories the cardAccessories to set
	 */
	public void setCardAccessories(double cardAccessories) {
		this.cardAccessories = cardAccessories;
	}

}
