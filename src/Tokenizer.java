import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer {
	public ArrayList<Token> tokens = new ArrayList<Token>();
	public String file;
	
	public Tokenizer(String file) {
		this.file = file;
	}
	
	public void tokenize() {
		try {
			File prgFile = new File(file);
			Scanner scan = new Scanner(prgFile);
			scan.useDelimiter(" ");
			
			while (scan.hasNext()) {
				String data = scan.next();
				if (data.startsWith("\n")) System.out.println("exists");
				Token t = Token.findToken(data);
				if (t != null) {
					tokens.add(t);
				} else {
					numSplit(data);
				}
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Tokenizer failed:");
			e.printStackTrace();
		}
	}
	
	public static void numSplit(String data) {
		try {
			Double.parseDouble(data);
		} catch (NumberFormatException e) {
			System.out.println(data);
		}
	}
}
