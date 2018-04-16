package br.com.novaroma.Automato;

import br.com.novaroma.Utils.Constt;
import br.com.novaroma.Utils.Util;

public class ProcessadorEstado {

	public ProcessadorEstado() {}

	public String processarEstadoQInicial(char c) {
		return Util.pertenceConjuntoLetrasOuUnderline(c) ? Constt.QACEITACAO : Constt.QREJEICAO;
	}
	
	public String processarEstadoQAceitacao(char c) {
		return Util.pertenceConjuntoOutros(c) ? Constt.QREJEICAO : Constt.QACEITACAO;
	}
}
