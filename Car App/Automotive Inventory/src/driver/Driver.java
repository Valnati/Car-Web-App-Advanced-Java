package driver;

import exception.AutoException;
import model.Automobile;
import util.FileInput;

public class Driver{

	public static void main(String[] args) throws AutoException {
		//Build Automobile object from a file
		FileInput file = new FileInput();
		Automobile FordZTW;
		FordZTW = file.readData("C:\\Users\\~ Adam ~\\Documents\\Computer Programming Notes\\Advanced Problem Solving\\FordZTW.txt");
		//print attributes before serialization
		FordZTW.printAuto(FordZTW);
		//Serialize object
		file.serializeAuto(FordZTW);
		//Deserialize the object and read it into memory
		Automobile newFordZTW = file.deserializeAuto("auto.ser");
		//print new attributes
		newFordZTW.printAuto(FordZTW);
	}
}
