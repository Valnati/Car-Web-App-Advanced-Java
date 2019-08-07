package Servlet;

import java.io.IOException;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.Server;

@WebServlet("/ServletModel")
public class ServletModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletModel() throws UnknownHostException {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				Server server = new Server();
				server.runServer();
			}
		});
		thread.start();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///Users/Adam/Documents/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
