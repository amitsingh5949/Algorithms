package com.whatfix.packageItem;

import java.util.List;

public class ItemsInfo {
	
	private int maxWeight;
	private List<Item> items;
	
	public ItemsInfo() {
		super();
	}

	public ItemsInfo(int maxWeight, List<Item> items) {
		super();
		this.maxWeight = maxWeight;
		this.items = items;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
