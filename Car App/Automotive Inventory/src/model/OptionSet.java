package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.OptionSet;

public class OptionSet implements Serializable{

	//variables
	private ArrayList<Option> opt;
	private String name;
	private Option choice; //update this choice and also update the automobile choice, when a choice is made
	
	//constructors
	protected OptionSet(String n, int size) {
		opt = new ArrayList<Option>(size);//change instantiation to arraylist
		name = n;
		for(int i=0; i<opt.size(); i++) {
			opt.set(i, new Option());
		}
	}

	protected OptionSet() {
	}

	//methods
	protected void createOptionsSet(int size) {
	    ArrayList<OptionSet> opSet = new ArrayList<OptionSet>(size);//creates OptionSet array
	}
	
	protected void createOption(int size) {
		this.opt = new ArrayList<Option>(size);
		for(int i=0; i<opt.size(); i++) {
			opt.set(i, new Option());
		}
	}

	protected void setOptionSetName(String newName) {
		name = newName; //to name the optionSet cells - color, transmission, etc
	}
	
	protected String getOptionSetName() {
		return name;
	}
	
	protected void setOption(int location, String newName, float newPrice) {
		this.opt.get(location).setName(newName); ;
		this.opt.get(location).setPrice(newPrice);
	}

	protected Option getOption(int location) {
		return this.opt.get(location);
	}
	
	public ArrayList<Option> getOption() {
		return opt;
	}
	
	protected int getOptionLength() {
		return this.opt.size();
	}
	
	protected void setOptionName(int location, String newName) {
		this.opt.get(location).setName(newName);
	}

	protected String getOptionName(int location) {
		return this.opt.get(location).getName();
	}
	
	protected void setOptionPrice(int location, float newPrice) {
		this.opt.get(location).setPrice(newPrice);
	}
	
	protected float getOptionPrice(int location) {
		return this.opt.get(location).getPrice();
	}
	
	protected Option getOptionChoice() {
		return choice;
	}
	
	protected void setOptionChoice(String optionName) {
		int location = findOptionName(optionName);
		choice = opt.get(location);
	}
	
	protected void deleteOptionSetName() {
		name = null;
	}
	
	protected void deleteOption(int location) {
		this.opt.get(location).deleteOption();
	}
	
	protected void deleteAllOptions() {
		for(int i = 0; i < opt.size(); i++) {
			opt.get(i).deleteOption();
		}
	}
	
	protected void deleteOptionName(int location) {
		this.opt.get(location).deleteName();
	}
	
	protected void deleteOptionPrice(int location) {
		this.opt.get(location).deletePrice();
	}
	
	protected int findOptionName(String name) {
		int location = -1;
		for(int i=0; i<opt.size(); i++) {
			if(this.opt.get(i).getName().equals(name)) {
				location = i;
			}
		}
		if( location == -1) {
			System.out.println("Could not find name");
		};
		return location;
	}
	
//	public Option findOption(String name) {
//		Option correctOption = null;
//		for(int i=0; i<opt.size(); i++) {
//			if(opt.get(i).getName().equals(name)) {
//				correctOption = opt.get(i);
//				return correctOption;
//			} 
//		System.out.println("Could not find model");
//		}
//	return correctOption;
//	}
	
	protected void print() {
		System.out.printf("%10s%n", name);
		for(int j=0; j<opt.size(); j++) {
			this.opt.get(j).print();
		}
	}
}