package model;

import java.io.Serializable;

public class Option implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private float price;
	
	Option(String newName, float newPrice){
		name = newName;
		price = newPrice;
	}

	protected Option() {
	}

	protected void print() {
		System.out.printf("%10s%n", name);
		System.out.printf("%10f%n", price);
	}
	
	protected void createOption(String name, float price) {
		Option opt = new Option(name, price);
	}
	
	protected void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}
	
	protected void setPrice(float newPrice) {
		price = newPrice;
	}

	public float getPrice() {
		return price;
	}
	
	protected void updateName(String newName) {
		name = newName;
	}
	
	protected void updatePrice(float newPrice) {
		price = newPrice;
	}
	
	protected void deleteOption() {
		deleteName();
		deletePrice();
	}
	
	protected void deleteName() {
		name = null;
	}
	
	protected void deletePrice() {
		price = 0;
	}
}
