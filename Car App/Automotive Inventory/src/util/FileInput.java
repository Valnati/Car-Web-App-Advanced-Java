package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.IllegalFormatException;
import java.util.Properties;

import exception.AutoException;
import model.*;

public class FileInput {
	public Automobile readData(String fileName) throws AutoException{
		//houses parser
		Automobile auto = new Automobile(); //just instantiate
		
		//if 'hybrid' = instantiate new hybrid object, place in LHM
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			String name = buff.readLine(); //Focus Wagon ZTW
			auto.setModel(name);
			String make = buff.readLine(); //Ford
			auto.setMake(make);
			String price = buff.readLine(); //18445
			auto.setPrice(Integer.parseInt(price));
			int opSetSize = Integer.parseInt(buff.readLine()); //5
			auto.createOptionsSet(opSetSize); //create optionSet of size 5
			for(int opSetLocation=0; opSetLocation < opSetSize; opSetLocation++) {
				int opSize = Integer.parseInt(buff.readLine()); //10
				auto.createOption(opSetLocation, opSize);
				String optionTitle = buff.readLine(); //Color
//				auto.createOption(opSetLocation, opSize);
				auto.setOptionSetName(opSetLocation, optionTitle);
				for (int opLocation=0; opLocation < opSize; opLocation++) { //loop to parse colors
					String optionName = buff.readLine(); //get color, gold
					float optionPrice = Float.parseFloat(buff.readLine()); //get price, 0.0
					auto.setOption(opSetLocation, opLocation, optionName, optionPrice);
				}
			}
		buff.close();	
		}
		catch(StreamCorruptedException e) {
			throw new AutoException(1, "StreamCorruptedException");
		}
		catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		catch (NumberFormatException e) {
			throw new AutoException(2, "NumberFormatException");
		}
		catch (IllegalFormatException e) {
			throw new AutoException(3, "IllegalFormatException");
		}		
		catch (IndexOutOfBoundsException e) {
			throw new AutoException(4, "IndexOutOfBoundsException");
		} return auto;
	}
	
	public void serializeAuto(Automobile auto) 
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.ser"));
			out.writeObject(auto);
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
	
	public Automobile deserializeAuto(String fileName) {
		Automobile newAuto = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			newAuto = (Automobile) in.readObject();
			in.close();
		}
		catch(IOException e) {
			System.out.print("Error: " + e);
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return newAuto;
	}
	
	public Automobile readProperties(String fileName) {
		Properties props = new Properties();
		Automobile auto = new Automobile(); //should we build a new auto object in here as well?

			FileInputStream in;
			try {
				in = new FileInputStream(fileName);
				props.load(in);
				String CarMake = props.getProperty("CarMake");
				if(!CarMake.equals(null)) {
					String CarModel = props.getProperty("CarModel");
					auto.setModel(CarModel);
					auto.setMake(CarMake);
					String price = props.getProperty("Price");
					auto.setPrice(Integer.parseInt(price));
					auto.createOptionsSet(4);
					
					auto.createOption(0, 2);
					String Option1 = props.getProperty("Option1");
					auto.setOptionSetName(0, Option1);
					String OptionValue1a = props.getProperty("OptionValue1a");
					Float opPrice = Float.parseFloat(props.getProperty("opPrice1a"));
					auto.setOption(0, 0, OptionValue1a, opPrice);
					String OptionValue1b = props.getProperty("OptionValue1b");
					opPrice = Float.parseFloat(props.getProperty("opPrice1b"));
					auto.setOption(0, 1, OptionValue1b, opPrice);
					
					String Option2 = props.getProperty("Option2");
					auto.createOption(1, 3);
					auto.setOptionSetName(1, Option2);
					String OptionValue2a = props.getProperty("OptionValue2a");
					opPrice = Float.parseFloat(props.getProperty("opPrice2a"));
					auto.setOption(1, 0, OptionValue2a, opPrice);
					String OptionValue2b = props.getProperty("OptionValue2b");
					opPrice = Float.parseFloat(props.getProperty("opPrice2b"));
					auto.setOption(1, 1, OptionValue2b, opPrice);
					String OptionValue2c = props.getProperty("OptionValue2c");
					opPrice = Float.parseFloat(props.getProperty("opPrice2c"));
					auto.setOption(1, 2, OptionValue2c, opPrice);
					
					String Option3 = props.getProperty("Option3");
					auto.createOption(2, 2);
					auto.setOptionSetName(2, Option3);
					String OptionValue3a = props.getProperty("OptionValue3a");
					opPrice = Float.parseFloat(props.getProperty("opPrice3a"));
					auto.setOption(2, 0, OptionValue3a, opPrice);
					String OptionValue3b = props.getProperty("OptionValue3b");
					opPrice = Float.parseFloat(props.getProperty("opPrice3b"));
					auto.setOption(2, 1, OptionValue3b, opPrice);
					
					String Option4 = props.getProperty("Option4");
					auto.createOption(3, 2);
					auto.setOptionSetName(3, Option4);
					String OptionValue4a = props.getProperty("OptionValue4a");
					opPrice = Float.parseFloat(props.getProperty("opPrice4a"));
					auto.setOption(3, 0, OptionValue4a, opPrice);
					String OptionValue4b = props.getProperty("OptionValue4b");
					opPrice = Float.parseFloat(props.getProperty("opPrice4b"));
					auto.setOption(3, 1, OptionValue4b, opPrice);
				}//add in new prices, one per line
				//how do we successfully move everything into an auto using existing methods? No size, price.
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return auto;
	}	
}