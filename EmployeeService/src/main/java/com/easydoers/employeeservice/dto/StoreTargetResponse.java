package com.easydoers.employeeservice.dto;

public class StoreTargetResponse {

	private int targetId;
	private int activationTargetToStore;
	private double accessoriesTargetToStore;
	private int hsiTargetToStore;
	private int tabletsTargetToStore;
	private int smartwatchTragetToStore;
	private String targetMonth;
	private StoreDTO store;

	/**
	 * @param targetId
	 * @param activationTargetToStore
	 * @param accessoriesTargetToStore
	 * @param hsiTargetToStore
	 * @param tabletsTargetToStore
	 * @param smartwatchTragetToStore
	 * @param targetMonth
	 * @param store
	 */
	public StoreTargetResponse(int targetId, int activationTargetToStore, double accessoriesTargetToStore,
			int hsiTargetToStore, int tabletsTargetToStore, int smartwatchTragetToStore, String targetMonth,
			StoreDTO store) {
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
	public String getTargetMonth() {
		return targetMonth;
	}

	/**
	 * @param targetMonth the targetMonth to set
	 */
	public void setTargetMonth(String targetMonth) {
		this.targetMonth = targetMonth;
	}

	/**
	 * @return the store
	 */
	public StoreDTO getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(StoreDTO store) {
		this.store = store;
	}

}
