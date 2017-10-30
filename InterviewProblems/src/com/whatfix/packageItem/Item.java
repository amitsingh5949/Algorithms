package com.whatfix.packageItem;

public class Item implements  Comparable<Item>{

	private int itemIndex;
	private float weight;
	private int price;
	
	public Item() {
		super();
	}

	public Item(int itemIndex, float weight, int price) {
		super();
		this.itemIndex = itemIndex;
		this.weight = weight;
		this.price = price;
	}
	
	public int compareTo(Item item){
		if(this.getPrice() != item.getPrice())
			return new Integer(this.getPrice()).compareTo(new Integer(item.getPrice()));
    	else
        return 0;
		}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
