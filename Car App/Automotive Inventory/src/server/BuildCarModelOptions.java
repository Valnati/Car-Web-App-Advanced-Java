package server;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import adapter.BuildAuto;
import adapter.ProxyAutomobile;
import model.Automobile;
import util.FileInput;

public class BuildCarModelOptions implements AutoServer{

	private FileInput file = new FileInput();
	private static BuildAuto auto;
	private LinkedHashMap<String, Automobile> LHM = ProxyAutomobile.getLHM();	//is this what we should do?
	//helper class for manipulating data - BCMO, implemented classes for manipulating data
	//defaultsocketclient calls on classes when necessary, giving info 
	
	public void createAutoFromProperties(String fileName) {
		//accept from client socket and create automobile
		auto = new BuildAuto();
		auto.createAutoFromProperties(fileName);
	}
	
	//enhanced methods
	@SuppressWarnings("unchecked")
	public ArrayList<String> listModelsToClient() {
		return (ArrayList<String>) LHM.keySet();
	}

	public void sendAutoToClient(ObjectOutputStream oos, String modelName) {
		auto.sendAutoToClient(oos, modelName);
	}
}
/** 2. Add​ ​a​ ​class​ ​BuildCarModelOptions​ ​class,​ 
​which​ ​has​ ​methods​ ​to​ ​do​ ​the​ ​following:
	a. Accept​ ​properties​ ​object​ ​from​ ​client​ ​socket​ 
	​over​ ​an​ ​ObjectStream​ ​and​ ​create​ ​an Automobile.  
	b. Then​ ​add​ ​that​ ​created​ ​Automobile​ ​to​ ​the​ ​LinkedHashMap.
	​ ​This​ ​method​ ​will​ ​be declared​ ​in​ ​the​ ​AutoServer​ ​interface.  
	c. AutoServer​ ​interface​ ​should​ ​be​ ​implemented​ ​in​ ​BuildAuto​ ​
	and BuildCarModelOptions​ ​classes.  
	d. Based​ ​on​ ​the​ ​current​ ​structure,​ ​this​ ​method​ ​will​ ​be​ 					<--- WHAT METHOD?​
	implemented​ ​in proxyAutomobile​ ​class​ ​and​ ​called​ ​in​ ​a​ 
	​method​ ​of​ ​BuildCarModelOptions. 
3. Setup​ ​a​ ​Java​ ​ServerSocket,​ ​which​ ​will​ ​run​ ​an​ ​instance​ ​
of​ ​BuildCarModelOption​ ​class​ ​to build​ ​Automobile​ ​using​ ​
the​ ​Properties​ ​file. */