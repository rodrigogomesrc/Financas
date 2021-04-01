package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Movimentacao;

public class Relatorio {
	
	ArrayList<Movimentacao> movimentacoes;
	
	public void carregarMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	

}
