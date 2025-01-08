package com.easydoers.employeeservice.entity;

import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StoreTarget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int targetId;
	private int activationTargetToStore;
	private double accessoriesTargetToStore;
	private int HSITargetToStore;
	private int tabletsTargetToStore;
	private int smartwatchTragetToStore;
	private YearMonth targetMonth;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	/**
	 * 
	 */
	public StoreTarget() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param targetId
	 * @param activationTargetToStore
	 * @param accessoriesTargetToStore
	 * @param hSITargetToStore
	 * @param tabletsTargetToStore
	 * @param smartwatchTragetToStore
	 * @param targetMonth
	 * @param store
	 */
	public StoreTarget(int targetId, int activationTargetToStore, double accessoriesTargetToStore, int hSITargetToStore,
			int tabletsTargetToStore, int smartwatchTragetToStore, YearMonth targetMonth, Store store) {
		super();
		this.targetId = targetId;
		this.activationTargetToStore = activationTargetToStore;
		this.accessoriesTargetToStore = accessoriesTargetToStore;
		HSITargetToStore = hSITargetToStore;
		this.tabletsTargetToStore = tabletsTargetToStore;
		this.smartwatchTragetToStore = smartwatchTragetToStore;
		this.targetMonth = targetMonth;
		this.store = store;
	}

	/**
	 * @return the targetId
	 */
	public int getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId the targetId to set
	 */
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	/**
	 * @return the activationTargetToStore
	 */
	public int getActivationTargetToStore() {
		return activationTargetToStore;
	}

	/**
	 * @param activationTargetToStore the activationTargetToStore to set
	 */
	public void setActivationTargetToStore(int activationTargetToStore) {
		this.activationTargetToStore = activationTargetToStore;
	}

	/**
	 * @return the accessoriesTargetToStore
	 */
	public double getAccessoriesTargetToStore() {
		return accessoriesTargetToStore;
	}

	/**
	 * @param accessoriesTargetToStore the accessoriesTargetToStore to set
	 */
	public void setAccessoriesTargetToStore(double accessoriesTargetToStore) {
		this.accessoriesTargetToStore = accessoriesTargetToStore;
	}

	/**
	 * @return the hSITargetToStore
	 */
	public int getHSITargetToStore() {
		return HSITargetToStore;
	}

	/**
	 * @param hSITargetToStore the hSITargetToStore to set
	 */
	public void setHSITargetToStore(int hSITargetToStore) {
		HSITargetToStore = hSITargetToStore;
	}

	/**
	 * @return the tabletsTargetToStore
	 */
	public int getTabletsTargetToStore() {
		return tabletsTargetToStore;
	}

	/**
	 * @param tabletsTargetToStore the tabletsTargetToStore to set
	 */
	public void setTabletsTargetToStore(int tabletsTargetToStore) {
		this.tabletsTargetToStore = tabletsTargetToStore;
	}

	/**
	 * @return the smartwatchTragetToStore
	 */
	public int getSmartwatchTragetToStore() {
		return smartwatchTragetToStore;
	}

	/**
	 * @param smartwatchTragetToStore the smartwatchTragetToStore to set
	 */
	public void setSmartwatchTragetToStore(int smartwatchTragetToStore) {
		this.smartwatchTragetToStore = smartwatchTragetToStore;
	}

	/**
	 * @return the targetMonth
	 */
	public YearMonth getTargetMonth() {
		return targetMonth;
	}

	/**
	 * @param targetMonth the targetMonth to set
	 */
	public void setTargetMonth(YearMonth targetMonth) {
		this.targetMonth = targetMonth;
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

	@Override
	public String toString() {
		return "StoreTarget [targetId=" + targetId + ", activationTargetToStore=" + activationTargetToStore
				+ ", accessoriesTargetToStore=" + accessoriesTargetToStore + ", HSITargetToStore=" + HSITargetToStore
				+ ", tabletsTargetToStore=" + tabletsTargetToStore + ", smartwatchTragetToStore="
				+ smartwatchTragetToStore + ", targetMonth=" + targetMonth + ", store=" + store + "]";
	}

	

}
