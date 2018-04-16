package br.com.novaroma.System;
import javax.swing.JOptionPane;

import br.com.novarom.Utils.Msg;
import br.com.novaroma.Entity.CardEntity;
import br.com.novaroma.Enum.State;

public class StateMachine {

	private State currStatus;
	private CardEntity cartao;
	
	public StateMachine() {
		this.currStatus = State.IDLE;
	}
	
	public void process (char c) throws Exception {
		
		ProcessStateMachine processStm = new ProcessStateMachine();
		State stateAux = null;
		switch(this.currStatus) {
			case IDLE: 
				stateAux = processStm.idle(c);
			break;
			case CARD:
				stateAux = processStm.card(c);
			break;
			case EMERGENCY:
				stateAux = processStm.emergency(c);
			break;
		}
		this.currStatus = stateAux;
	}
}
