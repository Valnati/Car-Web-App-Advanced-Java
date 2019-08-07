package server;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

public interface AutoServer {
	
	public void createAutoFromProperties(String fileName);
	
	//enhanced use - what should they return?
	public ArrayList<String> listModelsToClient();
	
	public void sendAutoToClient(ObjectOutputStream oos, String modelname);
	}

/**As​ ​part​ ​of​ ​this​ ​enhancement​ 
 * (the SelectCarOption one)
 * ​you​ ​will​ need​ ​to​ ​add​ ​new​ ​methods​ ​in​ 
 * ​​AutoServer​ interface​ ​to: 
 * 1. Provide​ ​a​ ​list​ ​of​ available​ ​models​ ​to​ ​the​ ​client. 
 * 2. Send​ ​the​ ​object​ ​(using​ ​Serialization)​ ​to​ 
 * ​the​ ​client,​ ​upon​ ​selection​ ​of​ ​an​ ​Automobile. 
 */