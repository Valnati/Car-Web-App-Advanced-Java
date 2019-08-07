package adapter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import exception.AutoException;
import model.*;
import scale.EditOptions;
import util.FileInput;

public abstract class ProxyAutomobile {

	private static LinkedHashMap<String, Automobile> autoList = new LinkedHashMap<String, Automobile>();

	private static ArrayList<String> autoTitle;
	
	private Automobile newAuto;
	
	private FileInput file = new FileInput();

	private EditOptions editOptions;
	
	public void buildAuto(String fileName, String fileType) {
		try {
			if(fileType == "Properties") {
				newAuto = file.readData(fileName);
				file.readProperties(fileName);
				StringBuilder key = new StringBuilder();
				key.append(newAuto.getMake() + " " + newAuto.getModel());
				autoList.put(key.toString(), newAuto);
				autoTitle.add(newAuto.getModel());
				}  else 
			newAuto = file.readData(fileName);
			StringBuilder key = new StringBuilder();
			key.append(newAuto.getMake() + " " + newAuto.getModel());
			autoList.put(key.toString(), newAuto);		
			} catch (AutoException e) {
			e.fix();
		}
//		auto.get(key).addAuto(newAuto); //add make and model, pass in model name too
		//test fleet object to add Auto and print auto added, guarantee that method worked
		//thinking in java for templates and LHMs
	};
	
	public void createAutoFromProperties(String fileName) {
		newAuto = file.readProperties(fileName);
		StringBuilder key = new StringBuilder();
		key.append(newAuto.getMake() + " " + newAuto.getModel());
		autoList.put(key.toString(), newAuto);
	}
	
	public static LinkedHashMap<String,Automobile> getLHM() {
		return autoList;
	}
	
	public static ArrayList<String> getArrayList() {
		return autoTitle;
	}
	
	
	public void addToLHM(Automobile newAuto) {
		StringBuilder key = new StringBuilder();
		key.append(newAuto.getMake() + " " + newAuto.getModel());
		autoList.put(key.toString(), newAuto);
	}
	
	public void printAuto(String key) {
		try {
		autoList.get(key).printAuto(autoList.get(key));
		} catch (AutoException e) {
			e.fix();
		}
	};
	//key, String modelName, String optionSetName, String newName
	public void updateOptionSetName(String key, String [] input) {
		Automobile currentAuto = autoList.get(key);	
		for (int i = 0; i < currentAuto.getOptionSetLength(); i++) {
				String optionSetName = input[2];
				String newName = input[3];
				if (currentAuto.getOptionSetName(i) == optionSetName ) {
					currentAuto.setOptionSetName(i, newName);
					break;
			}
		}
	};
	
	public void updateOptionPrice(String key, String modelName, String optionName, String option, float newPrice) {
		Automobile currentAuto = autoList.get(key);	
		for (int i = 0; i < currentAuto.getOptionSetLength(); i++) {
				for (int j = 0; j < currentAuto.getOptionLength(i); j++)
				if (currentAuto.getOptionName(i, j) == optionName) {
					currentAuto.setOptionPrice(i, j, newPrice);
					break;
			}//consider synchronizing whole methods here - no corruption
		}
	};
	
	public void Operation(int opNumber1, String [] input) {
		//instantiate editOptions
		editOptions.op(opNumber1, input);
	};
	
	public void sendAutoToClient(ObjectOutputStream oos, String modelName) {
		Automobile configAuto = autoList.get(modelName);
		if(configAuto == null) {
			System.err.println("No such model in server");
		}
		try {
			oos.writeObject(configAuto);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> listModelsToClient() {
		autoTitle = new ArrayList<String>();
		autoTitle.add("");
		Iterator<Entry<String, Automobile>> itr = autoList.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Automobile> entry = (Entry<String, Automobile>) itr
					.next();
			System.out.println("Entry key: " + entry.getKey());
			autoTitle.add(entry.getKey());
		}
		return autoTitle;
	}
	
	public void sendOutput(String out){
	}
}
