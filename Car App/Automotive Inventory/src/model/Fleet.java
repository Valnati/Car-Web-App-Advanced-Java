package model;

import java.util.LinkedHashMap;

import exception.AutoException;

public class Fleet<T extends Automobile> {
	private LinkedHashMap<String, T> auto;
	
	public Fleet<T> () {
		auto = new LinkedHashMap<String, T>();
	}
	
	//how to addcar method? Do we pass from ProxyAuto or BuildAuto or somewhere else?
	//without having a file object in this class?
	//file object instance of proxyauto
	private Automobile addAuto(Automobile newAuto) {
		try {
			auto.put(newAuto);
		} catch (AutoException e) {
			e.fix();
		}
	}
	
	//should it be passing in make? Does LHM access in this way?
	private Automobile getAuto(String make) {
		return auto.get(make);
	}
	
	//can you pass in T in this way?
	private void updateAuto(String make, T newAuto) {
		auto.put(make, newAuto);
	}
	
	private void deleteCar(String make) {
		auto.remove(make);
	}
	

	
	//CRUD methods:put(), get(), delete()
	//fileIO will need to differentiate between car types!
}
