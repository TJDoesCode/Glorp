package com.gmail.tjdoescode.glorp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Parses programs and splits into tokens and numbers to be evaluated separately
 * No actual program logic executed
 * @author Trevor R
 */
public class Tokenizer {
	public ArrayList<Token> tokens = new ArrayList<>();
	public ArrayList<Double> nums = new ArrayList<>();
	public ArrayList<Character> mathToks = new ArrayList<>();
	private int tokPtr = 0;
	private Logger log;
	private String file;
	
	// Various whitespace chars
	private ArrayList<Integer> whtsp = new ArrayList<>(Arrays.asList(3, 9, 10, 11, 12, 13, 27));
	// %, *, +, -, /, ^
	private ArrayList<Integer> mathSym = new ArrayList<>(Arrays.asList(37, 42, 43, 45, 47, 94));
	
	public Tokenizer(String file, LogLevel logLvl) {
		this.file = file;
		this.log = new Logger(logLvl);
	}
	
	public void tokenize() {
		try {
			File file = new File(this.file);
			Scanner scan = new Scanner(file);
			scan.useDelimiter("\n");
			
			while (scan.hasNext()) {
				String data = scan.next();
				log.emit("data: %s", data);
				
				String[] arr = data.split(" ");
				log.emit(Arrays.toString(arr));
				
				for (String tok : arr) {
					int firstChar = (int) tok.charAt(0);
					if (whtsp.contains(firstChar)) {
						log.emit("whitespace");
						// Whitespace characters are all ignored, this is a no-op
						continue;
					} else if (tok.charAt(0) == '(' && mathSym.contains((int) tok.charAt(1))) {
						log.emit("arithmetic operator %s", tok.charAt(1));
						parseExpr(tok.charAt(0));
						continue;
					}
					Token t = Token.findToken(tok);
					if (t != null) {
						tokens.add(t);
						tokPtr++;
						
						log.emit("TOKEN: %s", t.label);
					} else {
						parseNum(tok);
					}
				}
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			log.error("Tokenizer failed: ");
			e.printStackTrace();
		}
	}
	
	private void parseNum(String data) {
		try {
			double num = Double.parseDouble(data);
			nums.add(num);
			tokPtr++;
			
			log.emit("NUM: %.1f", num);
		} catch (NumberFormatException e) {
			log.emit("numEx: %s", data);
		}
	}
	
	private Object[] parseExpr(char op) {
		ArrayList<Object> expr = new ArrayList<>(3);
		System.out.println(nums);
		/*expr.add(nums.get(tokPtr - 1));
		expr.add(op);
		expr.add(nums.get(tokPtr + 1));*/
		
		
		System.out.println(expr);
		return expr.toArray(new Object[expr.size()]);
	}
}
