package com.gmail.tjdoescode.glorp;

/**
 * 
 * @author Trevor R
 */
public enum Token {
	END("end"),
	LOOP("loop"),
	PRINT("print"),
	UNTIL("until"),
	VAR("var");
	
	public final String label;
	
	private Token(String label) {
		this.label = label;
	}
	
	public static Token findToken(String keyw) {
		for (Token t : values()) {
			if (t.label.equals(keyw)) return t;
		}
		return null;
	}
}
