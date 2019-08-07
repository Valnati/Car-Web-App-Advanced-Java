package model;

import java.io.*;
import java.util.ArrayList;

import exception.AutoException;
import model.OptionSet;
import model.Option;

public class Automobile implements Serializable{

	//variables
	private String model;
	private String make;
	private float basePrice;
	private ArrayList<OptionSet> opSet;
	private ArrayList<Option> choice;
	
	//constructor
	public Automobile(int size, String n, float price) {
		opSet = new ArrayList<OptionSet>(size);
		model = n;
		basePrice = price;
		for(int i=0; i<opSet.size(); i++) {
			opSet.set(i, new OptionSet());
		}
	}
	
	public Automobile() {
	}
	
	public void createOptionsSet(int opSetSize) {
		ArrayList<OptionSet> opSet = new ArrayList<OptionSet>(opSetSize);	
	}
	
	public void createOption(int opSetLocation, int size) {
		this.opSet.set(opSetLocation, new OptionSet());
		this.opSet.get(opSetLocation).createOption(size);
	}
	
	public void setModel(String newModel) {
		model = newModel;
	}

	public String getModel() {
		return model;
	}

	public void setPrice(float price) {
		basePrice = price;
	}
	
	public float getPrice() {
		return basePrice;
	}
	
	public int getTotalPrice() {
		int total = 0;
		for(int i = 0; i < choice.size(); i++) {
			total += choice.get(i).getPrice();
		}
		return total;
	}
	
	public void setMake(String newMake) {
		make = newMake;
	}
	
	public String getMake() {
		return make;
	}
	
	public OptionSet getOptionSet(int location) {
		return opSet.get(location);//check what's returned
	}

	public void setOptionSetName(int opSetLocation, String opSetName) {
		this.opSet.get(opSetLocation).setOptionSetName(opSetName);
	}	
	
	public String getOptionSetName(int opSetLocation) {
		return this.opSet.get(opSetLocation).getOptionSetName();
	}
	
	public int getOptionSetLength() {
		return this.opSet.size();
	}
	
	public int getOptionLength(int opSetLocation) {
		return this.opSet.get(opSetLocation).getOptionLength();
	}
	
	public void setOption(int opSetLocation, int opLocation, String name, float price) {
		this.opSet.get(opSetLocation).setOption(opLocation, name, price);
	}
	
	public Option getOption(int opSetLocation, int opLocation) {
		return this.opSet.get(opSetLocation).getOption(opLocation);
	}
	
	public String getOptionName(int opSetLocation, int opLocation) {
		return this.opSet.get(opSetLocation).getOptionName(opLocation);
	}
	
	public void setOptionPrice(int opSetLocation, int opLocation, float newPrice) {
		this.opSet.get(opSetLocation).setOptionPrice(opLocation, newPrice);
	}
	
	public void setOptionChoice(String setName, String optionName) {
		int opSetLocation = opSet.indexOf(setName);
		int opLocation = opSet.get(opSetLocation).findOptionName(optionName);
		Option opChoice = getOption(opSetLocation, opLocation);
		//this sets an index of the choice ArrayList in Automobile
		choice.add(opChoice);
		//this sets the choice object in OptionSet opSet
		opSet.get(opSetLocation).setOptionChoice(optionName);
	}
	
	public String getOptionChoice(String setName) {
		int location = opSet.indexOf(setName);
		Option opChoice = opSet.get(location).getOptionChoice();
		return opChoice.getName();
	}
	
	public float getOptionChoicePrice(String setName) {
		int location = choice.indexOf(setName);
		return choice.get(location).getPrice();
	}
	
	public OptionSet findOptionSet(String name) {
		int location = -1;
		OptionSet correctOpSet = null;
		for(int i=0; i<opSet.size(); i++) {
			if(this.opSet.get(i).getOptionSetName().equals(name)) {
				location = i;
				correctOpSet = opSet.get(location);
				return correctOpSet;
			}
		}
		if( location == -1) {
			System.out.println("Could not find model");
		};
		return correctOpSet;
	}
	
	public Option findOption(String name) {
		int location = -1;
		Option correctOption = null;
		for(int i=0; i<opSet.size(); i++) {
			location = this.opSet.get(i).findOptionName(name);
			correctOption = opSet.get(i).getOption(location);
		}
		if( location == -1) {
			System.out.println("Could not find model");
		};
		return correctOption;
	}
	
	public void deleteOptionSet(int location) {
		this.opSet.get(location).deleteOptionSetName();
		this.opSet.get(location).deleteAllOptions();
	}
	
	public void deleteOption(int opSetLocation, int opLocation) {
		this.opSet.get(opSetLocation).deleteOption(opLocation);
	}

	public void printAuto(Automobile auto) throws AutoException {
		try {
		System.out.printf("%10s%n", model);
		System.out.printf("%10f%n", basePrice);
		for (int location=0; location<opSet.size(); location++) {
			this.opSet.get(location).print();
		}
		}catch (NullPointerException e) {
			throw new AutoException(5, "NullPointerException");
		}
	}
}