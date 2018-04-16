package br.com.novaroma.Enum;

public enum InputState {
	
	// r - relogio
	// c - cartao
	// b - botoeira
	// t - turnstile (catraca) 

	R('R'), C('C'), B('B'), T('T');
	
	private char c;
	
	InputState(char c) { this.c = c; };
	
	public char getChar() { return this.c; }

}
