package com.gmail.tjdoescode.glorp;

import java.util.Scanner;

/**
 * TODO: create true cli app
 * Currently runs in interactive mode or with supplied file
 * @author Trevor R
 */
public class Main {
	public static void main(String[] args) {
		Scanner cli = new Scanner(System.in);
		System.out.printf("Interactive mode? (Y/n)");
		String interact = cli.nextLine();
		
		if (interact == "" || interact.toUpperCase() == "Y" || interact.toUpperCase() == "YES") return;
		
		cli.close();
		
		// If CLI arg passed, use as file; otherwise use default path
		String defPath = "C:\\Users\\Trevor R\\Desktop\\Code\\Glorp\\Glorp\\test.txt";
		Tokenizer tok = new Tokenizer(args.length > 0 ? args[0]: defPath, LogLevel.DEV);
		
		tok.tokenize();
		
		System.out.println("TOKENS: " + tok.tokens);
		System.out.println("NUMBERS: " + tok.nums);
	}
}
