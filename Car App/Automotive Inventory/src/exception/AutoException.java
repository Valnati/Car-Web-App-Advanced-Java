package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;


public class AutoException extends Exception{
	private int errorno;
	private String errormsg;
	private HashMap<Integer,String> errorList = new HashMap<Integer,String>(){{
	    put(1, "StreamCorruptedException");
	    put(2, "NumberFormatException");
	    put(3, "IllegalFormatException");
	    put(4, "IndexOutOfBoundsException");
	    put(101, "NullPointerException");
	}};
		    
	public AutoException() {
		super();
		printmyproblem();
	}
	
	public AutoException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public AutoException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public AutoException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrono(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg); 
	}
	
	public Object fix() {
		
		Object fix = null;
		//1 to 100 involves fileInput errors
		Fix1to100 f1 = new Fix1to100();
		Fix101to200 f2 = new Fix101to200();
		
		switch(errorno){
		case 1: fix = f1.fix1(); return fix;
		case 2: fix = f1.fix2(); return fix;
		case 3: fix = f1.fix3(); return fix; 
		case 4: fix = f1.fix4(); return fix;
		case 5: fix = f2.fix101(); return fix;
		}
		return null;
	}
	
	public static void logError() {
	    try {
	        System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home")+"/error.log")));
	    } catch (FileNotFoundException ex) {
	         ex.printStackTrace();
	    }
	}
}
