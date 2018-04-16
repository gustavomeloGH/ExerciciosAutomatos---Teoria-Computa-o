package br.com.novaroma.Main;

import br.com.novaroma.Utils.Util;

public class Testes {

	public static void main (String [] args) {
		
		String[] numeros = {
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] letras = {
				"A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" , "L" , "M" , "N" , 
				"O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" , "W" , "X" , "Y" , "Z", 
				"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" ,
				"o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	
		String[] caracteresSemUnderline = {"!" , "\"" , "\\#" , "\\$" , "\\%" , "\\&" , "'" , "(" , ")" , 
				"*" , "+" , "," , "-" , "." , "/" , ":" , ";" , "<" , "=" , ">" , "?" , "@" , 
				"[" , "\\" , "]" , "^" , "`" , "{" , "|" , "}" , "~" };
		
		
		System.out.println("TESTES DOS MÉTODOS UTILS:");
		
		System.out.println("\nTeste UNDERLINE:");
		System.out.println("Teste Aceita UNDERLINE: " + Util.pertenceUnderline('_'));
		System.out.println("tESTE Aceita Números no UNDERLINE" + testarUnderline(numeros));
		System.out.println("tESTE Aceita LETRAS no UNDERLINE" + testarUnderline(letras));
		System.out.println("tESTE Aceita CARACTERES no UNDERLINE" + testarUnderline(caracteresSemUnderline));
		
		
		
		System.out.println("\nTeste LETRAS:");
		System.out.println("Teste Aceita LETRA: " + testarLetrasLetras(letras) );
		System.out.println("tESTE Aceita Números NAS LETRAS" + testarLetras(numeros));
		System.out.println("tESTE Aceita UNDERLINE NAS LETRAS" + Util.pertenceConjuntoLetras('_'));
		System.out.println("tESTE Aceita CARACTERES NAS LETRAS" + testarLetras(caracteresSemUnderline));
		
		
		System.out.println("\nTeste NUMEROS:");
		System.out.println("Teste Aceita Numeros: " + testarNumerosNumeros(numeros) );
		System.out.println("tESTE Aceita UNDERLINE NOS NUMEROS" +  Util.pertenceConjuntoNumeros('_'));
		System.out.println("tESTE Aceita LETRAS NOS NUMEROS" + testarNumeros(letras));
		System.out.println("tESTE Aceita CARACTERES NOS NUMEROS" + testarNumeros(caracteresSemUnderline));

		
		System.out.println("\nTeste APENAS LETRAS E UNDERLINE:");
		System.out.println("Teste Aceita Numeros: " + testarLU(numeros) );
		System.out.println("tESTE Aceita CARACTERES: " + testarLU(caracteresSemUnderline));
		System.out.println("tESTE Aceita UNDERLINE" +  Util.pertenceConjuntoLetrasOuUnderline('_'));
		System.out.println("tESTE Aceita LETRAS: " + testarLULU(letras));

		
		System.out.println("\nTeste APENAS OUTROS:");
		System.out.println("Teste Aceita Numeros: " + testarOutros(numeros) );
		System.out.println("tESTE Aceita CARACTERES: " + testarOutrosOutros(caracteresSemUnderline));
		System.out.println("tESTE Aceita UNDERLINE" +  Util.pertenceConjuntoOutros('_'));
		System.out.println("tESTE Aceita LETRAS: " + testarOutros(letras));

		
		
		

	}
	
	private  static boolean testarUnderline(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (Util.pertenceUnderline(string[i].toCharArray()[0])) {
				return true;
			}
		}
		return false;
	}
	
	private  static boolean testarLetras(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (Util.pertenceConjuntoLetras(string[i].toCharArray()[0])) {
				return true;
			}
		}
		return false;
	}
	
	private  static boolean testarLetrasLetras(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (!Util.pertenceConjuntoLetras(string[i].toCharArray()[0])) {
				return false;
			}
		}
		return true;
	}
	
	
	private  static boolean testarNumeros(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (Util.pertenceConjuntoNumeros(string[i].toCharArray()[0])) {
				return true;
			}
		}
		return false;
	}
	
	private  static boolean testarNumerosNumeros(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (!Util.pertenceConjuntoNumeros(string[i].toCharArray()[0])) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	private  static boolean testarLU(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (Util.pertenceConjuntoLetrasOuUnderline(string[i].toCharArray()[0])) {
				return true;
			}
		}
		return false;
	}
	
	
	private  static boolean testarLULU(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (!Util.pertenceConjuntoLetrasOuUnderline(string[i].toCharArray()[0])) {
				return false;
			}
		}
		return true;
	}
	
	
	private  static boolean testarOutros(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (Util.pertenceConjuntoOutros(string[i].toCharArray()[0])) {
				return true;
			}
		}
		return false;
	}
	
	
	private  static boolean testarOutrosOutros(String [] string) {
		for (int i = 0; i < string.length; i++) {
			if (!Util.pertenceConjuntoOutros(string[i].toCharArray()[0])) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
}
