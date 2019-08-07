package scale;

public interface Scalable {
	public void Operation(int opNumber1, String [] input);
	
}

//operations of CRUD for updating info while using multithreading


//updateOption(operationno, threadno, auto, optionset, fromcolor, tocolor, sleeptime) - synchronized
//different sleeptimes in nonsynch will cause data corruption

//how to test in a driver
//Scalable scalable = new BuildAuto();
//String input[] = {1, 1, "FordWagonZTW", "Color", "Blue", "Brown"}
//scalable.Operation(1, input)

//String input2[] = {1, 1, "FordWagonZTW", "Color", "Blue", "Black"}
//scalable.Operation(1, input2)

//could also just try changing price instead

//lots of print methods in auto, optionset, option is a good way to check data corruption and method working
//







//reuse previous CRUDS - create editoption object and call existing CRUD methods