package exception;

import java.util.Scanner;

//possible errors: nullpointer, wrong type, 
//no constructor, index not found
public final class Fix1to100 {
	public Fix1to100() {
		
	}

	//fix1 will fix the error of a corrupted file
	public String fix1() {
	    AutoException.logError();
		String newFile = "C:\\Users\\~ Adam ~\\Documents\\Computer Programming Notes\\Advanced Problem Solving\\FordZTW.txt";
		System.out.println("got here --> fixProblemReadFromConsole");
		return newFile;
	}
	
	//fix2 will fix an incorrect type of int when String was expected
	public String fix2() {
	    AutoException.logError();
		System.out.println("Expected a String, but there was a number.");
		System.out.println("Please type the intended String.");
        Scanner sc = new Scanner(System.in);
        // receive String input
        String name = sc.nextLine();
        sc.close();
        return name;
	}
	
	//fix3 will fix an incorrect type of String when int was expected
	public int fix3() {
	    AutoException.logError();
		System.out.println("Expected a number, but there was a String.");
		System.out.println("Please type the intended number.");
        Scanner sc = new Scanner(System.in);
        // receive String input
        int num = sc.nextInt();
        sc.close();
        return num;
	}

	public Object fix4() {
	    AutoException.logError();
		System.out.println("The array is not long enough to store this data.");
		return null;
	}
}
