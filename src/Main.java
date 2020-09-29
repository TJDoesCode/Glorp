
public class Main {
	public static void main(String[] args) {
		Tokenizer tok = new Tokenizer("C:\\Users\\Trevor R\\Desktop\\Code\\Glorp\\Glorp\\src\\test.txt");
		tok.tokenize();
		System.out.println(tok.tokens);
	}
}
