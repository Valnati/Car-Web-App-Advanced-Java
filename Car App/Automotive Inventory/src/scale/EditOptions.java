package scale;

import adapter.ProxyAutomobile;
import model.Automobile;

public class EditOptions extends ProxyAutomobile implements Runnable{

	int x;
	Automobile auto;
	int threadno;
	private Thread t;
	private boolean running=false;
	private boolean available = true; //shouldn't it start as true to allow threads to run?
	
    //not super relevant for this project
    public EditOptions(int x) {
      t = new Thread(this);
      t.setPriority(x);//main way to influence OS scheduler - through jvm, though jvm itself doesn't listen to this much
    }

    //what am I doing here exactly?
	public EditOptions(int x, Automobile auto, int threadno) {
		this.x = x;//switch statement number
		this.threadno = threadno;
		this.auto = auto;
	}
	
	public void start() {
	    t.start();
	}
		  
	public void stop() {
	    running = false;
	}

	public void run() {
		switch (x) {
		case 0:
			System.out.println("Start thread " + threadno + " Get");
			break;
		case 1:
			System.out.println("Start thread " + threadno + " Put");
			break;
		}
		Operation(threadno, null); //how to connect this to proxyauto, or op
		System.out.println("Stopping thread " + threadno);

	}
	//only place to synchronize - lock the relevant things you pass in as they are relevant
	public void op(int x, String [] input) {//your x from editOptions defines the switch case you use, because ops is a level down
		switch (x) {
		case 0:
			System.out.println("Thread 1 started.");
			while(available == false) {
				try {
					auto.wait();
					System.out.println("Waiting on other thread.");
				} catch (InterruptedException e) {
				System.out.println("Done waiting");
				}
			}
			available = false;
			synchronized(auto) {
				buildAuto("C:\\Users\\~ Adam ~\\Documents\\Computer Programming Notes\\Advanced Problem Solving\\FordZTW.txt", "");
				String key = input[2];
				updateOptionSetName(key, input); //use inherited methods and add to LHM, no need for object
			} 
			auto.notifyAll();
			available = true;
			break;

		case 1:
			System.out.println("Thread 2 started.");
			while(available == false) {
				try {
					auto.wait();
					System.out.println("Waiting on other thread.");
				} catch (InterruptedException e) {
				System.out.println("Done waiting");
				}
			}
			available = false;
			buildAuto("C:\\Users\\~ Adam ~\\Documents\\Computer Programming Notes\\Advanced Problem Solving\\FordZTW.txt", "");
			String key = input[2];
			updateOptionSetName(key, input);
			auto.notifyAll();
			available = true;
			break;
		}
	}
}
//scalable object ,string array, proxyauto method, 
		//call some method in EditOption class.
		//editoption is not abstract - call instance methods of
		//editoption, and instantiate editoption too
	 //this will need building out

	//method to call EditOption object for each new thread - synch and unsynch will be in proxyauto
	//synch method or block? method will not work - two instances of editoption
	//illegalmonitorstateexception - two synchronized but not actually synched editoptions
	//synch block will be easier option - synch object you want to modify
	//switch statement for synch/nonsynch


//


