package br.com.novaroma.Main;

import javax.swing.JOptionPane;

import br.com.novarom.Utils.Msg;
import br.com.novarom.Utils.Utils;
import br.com.novaroma.Entity.CardEntity;
import br.com.novaroma.System.StateMachine;

public class Main {

	public static void main (String[] args) {
		
		String inputCommand = getCommandInput();
		String inputCardValue = getCardValueInput();
		
		processSystem(inputCommand, Double.parseDouble(inputCardValue));
		
	}
	
	public static void shutDown() {
		JOptionPane.showMessageDialog(null, Msg.ENCERRARMSG);
		System.exit(0);
	}
	
	public static void processSystem(String inputCommand, double inputCardValue) {
		
		StateMachine stmMachine = new StateMachine();
		CardEntity.credito = inputCardValue;
		
		try {
			for (char c : inputCommand.toCharArray()) {
				stmMachine.process(c);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static String getCommandInput() {
		String input = Msg.EMPTY;
		do {
			input = JOptionPane.showInputDialog(Msg.INICIALMSG);
			if (input == null) {
				shutDown();
			}
		} while(input.isEmpty());

		return input;
	}
	
	public static String getCardValueInput() {
		String input = Msg.EMPTY;
		
		do {
			input = JOptionPane.showInputDialog(Msg.SALDOMSG);
			if (input == null) {
				shutDown();
			} else if (Utils.validateNumber(input)) {
				JOptionPane.showMessageDialog(null, Msg.ERRORNUMMSG);
				input = Msg.EMPTY;
			}
		} while (input.isEmpty());

		return input;
	}
	
}
