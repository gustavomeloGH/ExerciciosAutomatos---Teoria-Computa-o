package br.com.novaroma.Main;

import javax.swing.JOptionPane;

import br.com.novaroma.Automato.Automato;
import br.com.novaroma.Utils.Constt;
import br.com.novaroma.Utils.Msg;

public class Main {
	
	public static void main (String [] args) {
		
		Automato automato = new Automato(); 
		String input = Constt.EMPTY ;
		
		do {
			input = JOptionPane.showInputDialog(Msg.MAIN_INPUT);
			
			if (input != null) {
				automato.resetarAutomato();
				boolean pararProcessamento = false;
				
				for (int i = 0; i < input.length(); i++) {
					pararProcessamento = automato.processar(input.charAt(i));
					if (pararProcessamento) {
						break;
					}
				}
				JOptionPane.showMessageDialog(null, automato.imprimirResultado());
			}
		} while(input != null);
		
		JOptionPane.showMessageDialog(null, Msg.MAIN_ENCERRAR);
	}
}
