package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import adapter.BuildAuto;
import adapter.ProxyAutomobile;
import model.Automobile;
import util.FileInput;

public class CarModelOptionsIO {
	private BuildAuto build = new BuildAuto();
	private FileInput file;
	private ProxyAutomobile proxy;
	private Automobile auto;
	private Properties prop = new Properties();

	
	public void createProp(InputStream inputStream) throws IOException {
		prop.load(inputStream);

		//read data from properties, create prop object using load method
		//transfer object from client to server via objectstream
		//get signal that it was created successfully on other side
	}

	public void buildAuto(String filetype, String fileName) {
		//build auto and add to lhm
		auto = file.readProperties(fileName);
		proxy.addToLHM(auto);
	}
	
}