package test;

public class TsetClass {
	   public static void main(String[] args) {
		String text = "";
	
		try {
			text = new java.util.Scanner(new java.io.File("E:\\Android\\eclipse\\new.txt")).useDelimiter("\\Z").next();
		} catch (java.io.FileNotFoundException e2) {
			e2.printStackTrace();
		}
		if (text.length() == 0) {
			text = "There was no text";
	}
	}
}
