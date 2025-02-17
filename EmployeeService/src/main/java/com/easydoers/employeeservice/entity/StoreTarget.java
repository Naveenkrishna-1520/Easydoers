package com.easydoers.employeeservice.entity;

import java.time.YearMonth;

import com.easydoers.employeeservice.converter.YearMonthConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
	private int hsiTargetToStore;
	private int tabletsTargetToStore;
	private int smartwatchTragetToStore;
	@Column(nullable = false, length = 7) // Store as "YYYY-MM"
	@Convert(converter = YearMonthConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
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
	public StoreTarget(int targetId, int activationTargetToStore, double accessoriesTargetToStore, int hsiTargetToStore,
			int tabletsTargetToStore, int smartwatchTragetToStore, YearMonth targetMonth, Store store) {
		super();
		this.targetId = targetId;
		this.activationTargetToStore = activationTargetToStore;
		this.accessoriesTargetToStore = accessoriesTargetToStore;
		this.hsiTargetToStore = hsiTargetToStore;
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
	 * @return the hsiTargetToStore
	 */
	public int getHsiTargetToStore() {
		return hsiTargetToStore;
	}

	/**
	 * @param hsiTargetToStore the hsiTargetToStore to set
	 */
	public void setHsiTargetToStore(int hsiTargetToStore) {
		this.hsiTargetToStore = hsiTargetToStore;
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

}
