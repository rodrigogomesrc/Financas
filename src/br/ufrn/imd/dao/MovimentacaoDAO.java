package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Calendar;

import br.ufrn.imd.modelo.Movimentacao;
import br.ufrn.imd.modelo.TipoMovimentacao;


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
	
	public ArrayList<Movimentacao> getGastosMes(int mes, int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> gastosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GASTO) {
				continue;
			}
			
			cal.setTime(mov.getData());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			
			if(month == mes  && ano == year) {
				gastosMes.add(mov);
			}
		}
		
		return gastosMes;
	}
	
	public ArrayList<Movimentacao> getGanhosAno() {
		return null;
	}
	
	public ArrayList<Movimentacao> getGanhosMes(int mes, int ano) {
	
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> ganhosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GANHO) {
				continue;
			}
		
			cal.setTime(mov.getData());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			
			if(month == mes && year == ano) {
				ganhosMes.add(mov);
			}
		}
		return ganhosMes;
	}
	
	public int getNovaMovimentacaoId(){
		return this.movimentacoes.size();
	}

}
