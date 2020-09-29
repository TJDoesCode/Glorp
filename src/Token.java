
public enum Token {
	END("end"),
	PRINT("print");
	
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
