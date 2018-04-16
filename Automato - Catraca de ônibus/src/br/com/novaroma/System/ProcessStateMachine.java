package br.com.novaroma.System;

import javax.swing.JOptionPane;

import br.com.novarom.Utils.Msg;
import br.com.novarom.Utils.Utils;
import br.com.novaroma.Entity.BeepEntity;
import br.com.novaroma.Entity.CardEntity;
import br.com.novaroma.Entity.Solenoide;
import br.com.novaroma.Enum.InputState;
import br.com.novaroma.Enum.State;

public class ProcessStateMachine {

	private State state;
	
	public ProcessStateMachine() {
		state = null;
	}
	
	
	public State idle(char c) throws Exception {
		
		InputState inputState = getInputStateByC(c);
		
		switch(inputState) {
			case R:
				JOptionPane.showMessageDialog(null, String.format("%s \n%s %s", Msg.TARIFAMSG, Msg.DATEINFOMSG, Utils.getCurrentDate()));
				state = State.IDLE;
			break;
			case C:
				if (CardEntity.doCardDebit()) {
					Solenoide.unlock();
					JOptionPane.showMessageDialog(null, String.format("%s\n%s %.2f",Msg.IDLEMSGC, Msg.SALDOATUALMSG, CardEntity.credito));
					state = State.CARD;
				} else {
					throw new Exception(String.format("%s\n%s\n%s %.2f", Msg.ERRORCARDEMPTYMSG, Msg.ENCERRARMSG, Msg.SALDOATUALMSG, CardEntity.credito));
				}
			break;
			case B:
				Solenoide.unlock();
				JOptionPane.showMessageDialog(null, Msg.EMERGENCIAMSG);
				state = State.EMERGENCY;
			break;
			case T:
				Solenoide.lock();
				JOptionPane.showMessageDialog(null, Msg.IDLEMSGT);
				state = State.IDLE;
			break;
			default:
				throw new Exception();
		}
		return state;
	}
	
	public State card(char c) throws Exception {
		
		InputState inputState = getInputStateByC(c);
		
		switch(inputState) {
			case R:
				BeepEntity.alert();
				JOptionPane.showMessageDialog(null, Msg.CARDMSGR);
				state = State.CARD;
			break;
			case C:
				BeepEntity.alert();
				JOptionPane.showMessageDialog(null, Msg.CARDMSGC);
				state = State.CARD;
			break;
			case B:
				Solenoide.unlock();
				JOptionPane.showMessageDialog(null, Msg.EMERGENCIAMSG);
				state = State.EMERGENCY;
			break;
			case T:
				Solenoide.lock();
				JOptionPane.showMessageDialog(null,  Msg.CARDMSGT);
				state = State.IDLE;
			break;
			default:
				throw new Exception(String.format("%s %s\n%s", Msg.COMANDOERROMSG, c, Msg.ENCERRARMSG));
		}
		return state;
	}
	
	public State emergency(char c) throws Exception {
		
		InputState inputState = getInputStateByC(c);
		
		switch(inputState) {
			case R:
				BeepEntity.alert();
				JOptionPane.showMessageDialog(null, Msg.EMERGENCIAMSG);
				state = State.EMERGENCY;
			break;
			case C:
				BeepEntity.alert();
				JOptionPane.showMessageDialog(null, Msg.EMERGENCYMSGC);
				state = State.EMERGENCY;
			break;
			case B:
				Solenoide.lock();
				JOptionPane.showMessageDialog(null, Msg.EMERGENCYMSGB);
				state = State.IDLE;
			break;
			case T:
				JOptionPane.showMessageDialog(null, Msg.EMERGENCYMSGT);
				state = State.EMERGENCY;
			break;
			default:
				throw new Exception(String.format("%s %s\n%s", Msg.COMANDOERROMSG, c, Msg.ENCERRARMSG));
		}
		return state;
	}
	
	private InputState getInputStateByC(char c) throws Exception {
		try { 
			return InputState.valueOf(String.valueOf(c).toUpperCase());
		} catch (Exception e) {
			throw new Exception(String.format("%s %s\n%s", Msg.COMANDOERROMSG, c, Msg.ENCERRARMSG));
		}
	}
}
