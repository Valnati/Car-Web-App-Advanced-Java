package client;

import java.net.*;
import java.io.*;

public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket sock;
	private String strHost;
	private int iPort;
    String inputLine;
	
	public DefaultSocketClient(String strHost, int iPort) {
		setPort (iPort);
		setHost(strHost);
	}
	
	public void run() {
		if(openConnection()) {
			handleSession();
			closeSession();
		}
	}
	
	public boolean openConnection() {
		try {
			sock = new Socket(strHost, iPort);
		} catch(IOException socketError) {
			if(DEBUG) {
				System.err.println("Unable to obtain stream to/from" + strHost);
				return false;
				}
		}
		try {
            writer = new ObjectOutputStream(sock.getOutputStream());
            reader = new ObjectInputStream(sock.getInputStream());
		} catch (Exception e) {
			if (DEBUG) {
				System.err.println("Unable to obtain stream to/from " + strHost);
				return false;
			}
		}
		return true;
	}
	
	//effective protocol - do things based on what it is, and use streams here only
	public void handleSession() {
       try {
			while ((inputLine = (String) reader.readObject()) != null) {
				//Do the stuff!
		        if (inputLine.equals("Bye.")) {
		        	
		        }
		        else if (inputLine.equals("Bye.")) {
		        	
		        }
		        if (inputLine.equals("Bye."))
		        break;
			}
		} catch (ClassNotFoundException | IOException e) {
				System.out.println("Something broke.");
		}
	}
	
	public void sendOutput (String out){
	  	  try {
	    	    writer.writeObject(out);
		  } catch (IOException e) {
			  if(DEBUG) {
			  	  System.out.println("Error writing to " + strHost);
			  }
		  }
	}
	
	public void handleInput(String strInput) {
		System.out.println(strInput);
	}
	
	public void closeSession() {
		try {
			writer = null;
			reader=null;
			sock.close();
		} catch (IOException e) {
			if(DEBUG) {
				System.err.println("Error closing socket to " + strHost);
			}
		}
	}
	
	public void setHost(String strHost) {
		this.strHost = strHost;
	}
	
	public void setPort(int iPort) {
		this.iPort = iPort;
	}
	
	public static void main(String arg[]) {
		String strLocalHost="";
		try {
			strLocalHost = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.err.println("Unable to find local host"); }
		DefaultSocketClient d = new DefaultSocketClient (strLocalHost, iDAYTIME_PORT);
		d.start();
	}
}