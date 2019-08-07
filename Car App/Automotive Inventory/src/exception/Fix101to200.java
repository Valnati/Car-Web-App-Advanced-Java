package exception;

public final class Fix101to200 {
	public Fix101to200() {
		
	}

	public Object fix101() {
	    AutoException.logError();
	    System.out.println("Auto object does not exist and will not be printed.");
		return null;
	}
}
