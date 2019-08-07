package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//infinite loop accepting requests of socket and creating defaultsocketclient objects to handle them
	
	private ServerSocket serverSocket = null;
	
	public void connectServer() throws IOException {
	    ServerSocket serverSocket = null;
	    serverSocket = new ServerSocket(4444);
	            
	    Socket clientSocket = null;
	    clientSocket = serverSocket.accept(); //clientSocket passed to defsockclient
	    new DefaultSocketClient(clientSocket).start();
	}
	
	public void runServer() {
		DefaultSocketClient defaultClientSocket = null;
		try {
			while(true) {
				Socket socket = serverSocket.accept();
				defaultClientSocket = new DefaultSocketClient(serverSocket, socket);
	            defaultClientSocket.start();
			}
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.runServer();
	}
}
