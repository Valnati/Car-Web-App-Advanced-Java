package client;

import java.io.IOException;

public interface SocketClientInterface {
	boolean openConnection();
	void handleSession() throws ClassNotFoundException, IOException;
	void closeSession();
}
