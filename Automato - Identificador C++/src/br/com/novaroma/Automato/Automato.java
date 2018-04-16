package br.com.novaroma.Automato;

import br.com.novaroma.Utils.Constt;
import br.com.novaroma.Utils.Msg;

public class Automato {

	private String estadoAtual;
	private ProcessadorEstado processadorEstado;
	private boolean estadoRejeicao;

	public Automato() {
		processadorEstado = new ProcessadorEstado();
	}

	public void resetarAutomato() {
		this.estadoAtual = Constt.QINICIAL;
		this.estadoRejeicao = false;
	}

	public boolean processar(char c) {
		String estadoPosProcessamento = Constt.EMPTY;

		switch (estadoAtual) {
			case Constt.QINICIAL:
				estadoPosProcessamento = processadorEstado.processarEstadoQInicial(c);
				break;
			case Constt.QACEITACAO:
				estadoPosProcessamento = processadorEstado.processarEstadoQAceitacao(c);
				break;
			case Constt.QREJEICAO:
				estadoRejeicao = true;
				break;
		}
		this.estadoAtual = estadoPosProcessamento;
		return estadoRejeicao;
	}

	public String imprimirResultado() {
		String msgImpressao = Constt.EMPTY;

		switch (this.estadoAtual) {
			case Constt.QINICIAL:
				msgImpressao = Msg.QINICIAL;
				break;
			case Constt.QACEITACAO:
				msgImpressao = Msg.QACEITACAO;
				break;
			case Constt.QREJEICAO:
				msgImpressao = Msg.QREJEICAO;
				break;
		}
		return msgImpressao;
	}

}
