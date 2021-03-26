package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Movimentacao;


public class MovimentacaoDAO {
	
	private static MovimentacaoDAO instancia;
	private ArrayList<Movimentacao> movimentacoes;
	
	public MovimentacaoDAO() {
		this.movimentacoes = new ArrayList<Movimentacao>();
	}

	public static synchronized MovimentacaoDAO getInstancia() {
		if (instancia == null)
			instancia = new MovimentacaoDAO();

		return instancia;
	}
	
	public void salvarMovimentacao(Movimentacao movimentacao) {
		this.movimentacoes.add(movimentacao);
	}
	
	public ArrayList<Movimentacao> getMovimentacoes(){
		return this.movimentacoes;
	}
	
	public Movimentacao getMovimentacao(String idMovimentacao) {
		for(Movimentacao m: this.movimentacoes) {
			if(m.getId().equals(idMovimentacao)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Movimentacao> getMovimentacoesAno() {
		return null;
	}
	
	public ArrayList<Movimentacao> getMovimentacoesMes() {
		return null;
	}
	
	public ArrayList<Movimentacao> getGastosAno() {
		return null;
	}
	
	public ArrayList<Movimentacao> getGastosMes() {
		return null;
	}
	
	public ArrayList<Movimentacao> getGanhosAno() {
		return null;
	}
	
	public ArrayList<Movimentacao> getGanhosMes() {
		return null;
	}
	
	public int getNewCategoriaId(){
		return this.movimentacoes.size();
	}

}
