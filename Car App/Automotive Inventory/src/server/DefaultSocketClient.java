package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;

import client.SocketClientConstants;
import client.SocketClientInterface;

public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants{
	
	private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Socket sock;
    private ServerSocket serverSocket;
    String inputLine;
	AutoServer build = new BuildCarModelOptions();
    
	public DefaultSocketClient(Socket sock) {
		this.sock = sock;
    System.out.println("constructor--"+sock);
    try {
      	this.writer = new  ObjectOutputStream(sock.getOutputStream());
      	this.reader = new ObjectInputStream(sock.getInputStream());
    }
 	catch (Exception e){
 	    if (DEBUG) System.err.println("Unable to obtain stream to/from " );
 		}
	}
	
	public DefaultSocketClient(ServerSocket serverSocket, Socket sock) {
		this.serverSocket = serverSocket;
		this.sock = sock;
	}
	
	public void run(){
	boolean state=true;
	while(state){
		if(openConnection()) {
			System.out.println("starting run....");
		    handleSession();
		    state=false;
		    closeSession();
		    }
		}
	}
	
	public boolean openConnection(){
    	try {
            writer = new ObjectOutputStream(sock.getOutputStream());
            reader = new ObjectInputStream(sock.getInputStream());
    	} catch (Exception e) {
    		if (DEBUG) System.err.println
    	       ("Unable to obtain stream");
    		return false;
    	}
	    return true;
	}
	
	public void handleSession() {
		String theInput = null;
		try {
			theInput = (String) reader.readObject();
		} catch (ClassNotFoundException | IOException e1) {

		}
		if(theInput.equalsIgnoreCase("Load")) {
			String fileName = null;
			while (fileName == null) {
				try {
					fileName = (String) reader.readObject();
				} catch (ClassNotFoundException | IOException e) {

				}
			}
            try {
            	build.createAutoFromProperties(fileName);
                String response = "Automobile built successfully.";
				sendOutput(response);
                writer.flush();
                System.out.println(response);
			} catch (IOException e) {
				System.out.println("Path could not be read.");
			}
            build.createAutoFromProperties(fileName);
			System.out.println("Upload complete.");
		}
		else if (theInput.equalsIgnoreCase("Configure")) {
			ArrayList<String> modelList = build.listModelsToClient();
            System.out.println("Choose your car by title name.");
            sendOutput(modelList);
            String configModel = null;
			try {
				configModel = (String) reader.readObject();
			} catch (ClassNotFoundException | IOException e) {

			}
			System.out.println("You have chosen " + configModel);
			build.sendAutoToClient(writer, configModel);           
			System.out.println("Configure complete.");
		} else if (theInput.equalsIgnoreCase("Show Models")) {
			ArrayList<String> modelList = build.listModelsToClient();
            sendOutput(modelList);			
            System.out.println("Showing models.");
		} else if (theInput.equalsIgnoreCase("Bye")) {
			System.out.println("Thanks for all the fish.");
		}
	}
	
	public void sendOutput(ArrayList<String> response){
	  	try {
	  	    for(String spot: response) {
	  	  	    writer.writeObject(response);
	  	    }
	  	} catch (IOException e){
	  	    if (DEBUG) System.out.println 
              ("Error writing ");
	  	}
	}

	public void sendOutput(String response){
  	  try {
  	    writer.writeObject(response);
  	  }
  	  catch (IOException e){
  	    if (DEBUG) System.out.println 
  	               ("Error writing ");
  	  }
  	}
	
    public void handleInput(String strInput){
        System.out.println(strInput);
    }       

    public void closeSession(){
        try {
	        writer = null;
	        reader = null;
	        sock.close();
        }
        catch (IOException e){
            if (DEBUG) System.err.println("Error closing socket to " );
        }       
    }
	//accept socket from the defaultclient, 
	//socket to conduct manipulations using buildcarmodeloptions methods
}
//need port info in server and client, could hardcode in driver for easier switching