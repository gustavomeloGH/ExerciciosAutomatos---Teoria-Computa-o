package br.com.novaroma.Utils;

public class Util {
	
	private final static char UNDERLINE = '_';

	 
	public static boolean pertenceConjuntoLetrasOuUnderline(char c) {
		return (!pertenceConjuntoNumeros(c) && !pertenceConjuntoOutros(c));
	}
	
	public static boolean pertenceConjuntoOutros(char c) {
		return !pertenceConjuntoLetras(c) 
				&& !pertenceConjuntoNumeros(c) 
				&& !pertenceUnderline(c);
	}

	public static boolean pertenceUnderline(char c) {
		return c == UNDERLINE;
	}
	
	public static boolean pertenceConjuntoNumeros(char c) {
		return (String.valueOf(c).matches("^[0-9]*$"));
	}
	
	
	public static boolean pertenceConjuntoLetras(char c) {
		return (String.valueOf(c).matches("^[a-zA-Z]*$"));
	}
	


}
