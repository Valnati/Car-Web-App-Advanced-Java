package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;

public class Driver2 {
	public static void main(String args[]){
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("C:\\Users\\~ Adam ~\\Documents\\Computer Programming Notes\\Advanced Problem Solving\\FordZTW.txt"); //set buildAuto's Automotive object to a nonnull value
		a1.printAuto();
		UpdateAuto a2 = new BuildAuto(); //ideally build a copy of auto
		a2.updateOptionSetName("modelName", "optionSetName", "newName");
		a2.updateOptionPrice("modelName", "optionName", "option", 1);
		}
}
//printAuto gives nullPointer - how to properly pass arguments along?
