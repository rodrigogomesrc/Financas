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
	
	public ArrayList<Movimentacao> getMovimentacoesAno(int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> movimentacoesAno = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
	
			cal.setTime(mov.getData());
			int year = cal.get(Calendar.YEAR);
			
			if(ano == year) {
				movimentacoesAno.add(mov);
			}
		}
		
		return movimentacoesAno;
	}
	
	public ArrayList<Movimentacao> getMovimentacoesMes(int mes, int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> movimentacoesMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
	
			cal.setTime(mov.getData());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			
			if(month == mes  && ano == year) {
				movimentacoesMes.add(mov);
			}
		}
		
		return movimentacoesMes;
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
	
	public ArrayList<Movimentacao> getGastosAno(int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> gastosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GASTO) {
				continue;
			}
			
			cal.setTime(mov.getData());
			int year = cal.get(Calendar.YEAR);
			
			if(ano == year) {
				gastosMes.add(mov);
			}
		}
		
		return gastosMes;
	}
	
	public ArrayList<Movimentacao> getGanhosAno(int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> ganhosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GANHO) {
				continue;
			}
		
			cal.setTime(mov.getData());
			int year = cal.get(Calendar.YEAR);
			
			if(year == ano) {
				ganhosMes.add(mov);
			}
		}
		return ganhosMes;
	}
	
	public int getNovaMovimentacaoId(){
		return this.movimentacoes.size();
	}

}
