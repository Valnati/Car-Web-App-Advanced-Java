package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;
import model.Automobile;
import scale.EditOptions;
import scale.Scalable;

public class Driver4 {
	public static void main(String args[]){
		Scalable a1 = new BuildAuto();
		String input[] = {"1", "1", "Ford Focus Wagon ZTW", "Ford", "Color", "Experience"};
		a1.Operation(0, input);

		String input2[] = {"1", "1", "Ford Focus Wagon ZTW", "Color", "Blue", "Black"}
		a1.Operation(1, input2);
		
		a1.buildAuto("C:\\Users\\~ Adam ~\\Documents\\Computer Programming Notes\\Advanced Problem Solving\\FordZTW.txt"); //set buildAuto's Automotive object to a nonnull value
//		EditOptions autoOption1 = new EditOptions(0, (Automobile) a1, 1);//is this a good idea?
//		EditOptions autoOption2 = new EditOptions(1, (Automobile) a1, 2);//is this a good idea?
//		autoOption1.printAuto("Ford Focus Wagon ZTW");
//		autoOption2.printAuto("Ford Focus Wagon ZTW");
//		autoOption1.updateOptionSetName("Ford Focus Wagon ZTW", "Ford", "Color", "Experience");
//		autoOption2.updateOptionSetName("Ford Focus Wagon ZTW", "Ford", "Color", "Tambre");
//		autoOption1.updateOptionPrice("Ford Focus Wagon ZTW", "Ford", "Side Impact Air Bags", "present", 260);
//		autoOption2.updateOptionPrice("Ford Focus Wagon ZTW", "Ford", "Transmission", "Automatic", 180);
		}
}

//updateOption(operationno, threadno, auto, optionset, fromcolor, tocolor, sleeptime) - synchronized
//different sleeptimes in nonsynch will cause data corruption

//how to test in a driver
//Scalable scalable = new BuildAuto();
//String input[] = {1, 1, "FordWagonZTW", "Color", "Blue", "Brown"}
//scalable.Operation(1, input)

//String input2[] = {1, 1, "FordWagonZTW", "Color", "Blue", "Black"}
//scalable.Operation(1, input2)

//could also just try changing price instead

//lots of print methods in auto, optionset, option is a good way to check data corruption and method working
//