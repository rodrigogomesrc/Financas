package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Movimentacao;

public class Relatorio {
	
	ArrayList<Movimentacao> movimentacoes;
	
	public void carregarMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public String getGanhosPorCategoria() {
		if(this.movimentacoes == null) {
			return "";
		}
		
		return "";
	}
	
	public String getGastosPorCategoria() {
		if(this.movimentacoes == null) {
			return "";
		}
		return "";
	}
	
	public String getGanhosTotais() {
		if(this.movimentacoes == null) {
			return "";
		}
		return "";
	}
	
	public String getGastosTotais() {
		if(this.movimentacoes == null) {
			return "";
		}
		return "";
	}

}
