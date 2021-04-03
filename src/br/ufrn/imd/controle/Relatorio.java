package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.HashMap;

import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Movimentacao;
import br.ufrn.imd.modelo.TipoMovimentacao;

public class Relatorio {
	
	ArrayList<Movimentacao> movimentacoes;
	
	public void carregarMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public String getGanhosPorCategoria() {
		return this.getGanhosPorCategoria(true);
	}
	
	public String getGanhosPorCategoria(Boolean header) {
		if(this.movimentacoes == null || this.movimentacoes.size() == 0) {
			return "Não há ganhos para mostrar\n";
		}
		
		ArrayList<Movimentacao> ganhos = this.getGanhos();
		if(ganhos == null || ganhos.size() == 0) {
			return "Não há ganhos para mostrar\n";
		}
		
		CategoriaDAO categoriaDAO = CategoriaDAO.getInstancia();
		ArrayList<Categoria> categorias = categoriaDAO.getCategorias();
		HashMap<String,Double> ganhosPorCategoria = new HashMap<String,Double>();
		HashMap<String,Double> ganhosPorCategoriaPorcentagem = new HashMap<String,Double>();
		Double ganhosTotal = this.getGanhosTotais();
		
		for(Categoria cat: categorias) {
			ganhosPorCategoria.put(cat.getId(), 0.0);
		}
		
		for(Movimentacao ganho: ganhos) {
			Double ganhoCategoria = ganhosPorCategoria.get(ganho.getCategoriaId());
			ganhoCategoria += ganho.getValorMovimentacao();;
			ganhosPorCategoria.put(ganho.getCategoriaId(), ganhoCategoria);
		}
		
		for(Categoria cat: categorias) {
			Double ganhoCategoria = ganhosPorCategoria.get(cat.getId());
			Double porcentagem = (ganhoCategoria * 100) / ganhosTotal;
			ganhosPorCategoriaPorcentagem.put(cat.getId(), porcentagem);
		}
		
		String output = "";
		if(header) {
			output += "********** GANHOS POR CATEGORIA **********\n";
		}
		
		for(Categoria cat: categorias) {
			output += "\n";
			output += 
					cat.getNomeCategoria() + ": " 
			+ ganhosPorCategoria.get(cat.getId()) 
			+ " = " + Math.round(ganhosPorCategoriaPorcentagem.get(cat.getId())*100.0)/100.0
			+ "%" + "\n";
			
		}
		
		return output;
	}
	
	public String getGastosPorCategoria() {
		return this.getGanhosPorCategoria(true);
	}
	
	public String getGastosPorCategoria(Boolean header) {
		
		if(this.movimentacoes == null || this.movimentacoes.size() == 0) {
			return "Não há gastos para mostrar\n";
		}
		
		ArrayList<Movimentacao> gastos = this.getGastos();
		if(gastos == null || gastos.size() == 0) {
			return "Não há gastos para mostrar\n";
		}
		
		CategoriaDAO categoriaDAO = CategoriaDAO.getInstancia();
		ArrayList<Categoria> categorias = categoriaDAO.getCategorias();
		HashMap<String,Double> gastoPorCategoria = new HashMap<String,Double>();
		HashMap<String,Double> gastoPorCategoriaPorcentagem = new HashMap<String,Double>();
		Double gastoTotal = this.getGastosTotais();
		
		for(Categoria cat: categorias) {
			gastoPorCategoria.put(cat.getId(), 0.0);
		}
		
		for(Movimentacao gasto: gastos) {
			Double gastoCategoria = gastoPorCategoria.get(gasto.getCategoriaId());
			gastoCategoria += gasto.getValorMovimentacao();
			gastoPorCategoria.put(gasto.getCategoriaId(), gastoCategoria);
		}
		
		for(Categoria cat: categorias) {
			Double gastoCategoria = gastoPorCategoria.get(cat.getId());
			Double porcentagem = (gastoCategoria * 100) / gastoTotal;
			gastoPorCategoriaPorcentagem.put(cat.getId(), porcentagem);
		}
		
		String output = "";
		if(header) {
			output += "********** GASTOS POR CATEGORIA **********\n";
		}
		
		for(Categoria cat: categorias) {
			output += "\n";
			output += 
					cat.getNomeCategoria() + ": " 
			+ gastoPorCategoria.get(cat.getId()) 
			+ " = " + Math.round(gastoPorCategoriaPorcentagem.get(cat.getId())*100.0)/100.0 
			+ "%" + "\n";
			
		}
		
		return output;
	}
	
	public String getRelatorioGeral() {
		return this.getRelatorioGeral(true);
	}
	
	public String getRelatorioGeral(Boolean header) {
		if(this.movimentacoes == null || this.movimentacoes.size() == 0) {
			return "Sem dados para mostrar\n";
		}
		
		String output = "";
		if(header) {
			output += "********** RELATÓRIO GERAL **********\n";
		}
		
		output += "\n";
		output += "Gastos Totais: " + String.valueOf(this.getGastosTotais()) + "\n";
		output += "Ganhos Totais: " + String.valueOf(this.getGanhosTotais()) + "\n";
		output += "Saldo Total: " + String.valueOf(this.getSaldo()) + "\n";
		
		return output;
		
	}
	
	private Double getGanhosTotais() {
		Double ganhosTotais = 0.0;
		ArrayList<Movimentacao> ganhos = this.getGanhos();
		
		if(ganhos == null) {
			return ganhosTotais;
		}
		
		for(Movimentacao mov: ganhos) {
			ganhosTotais += mov.getValorMovimentacao();
		}
		
		return ganhosTotais;
	}
	
	private Double getGastosTotais() {
		Double gastosTotais = 0.0;
		ArrayList<Movimentacao> gastos = this.getGastos();
		
		if(gastos == null) {
			return gastosTotais;
		}
		
		for(Movimentacao mov: gastos) {
			gastosTotais += mov.getValorMovimentacao();
		}
		
		return gastosTotais;
	}
	
	private Double getSaldo() {
		return this.getGanhosTotais() - this.getGastosTotais();
	}
	
	private ArrayList<Movimentacao> getGastos(){

		if(this.movimentacoes == null) {
			return null;
		}
		ArrayList<Movimentacao> gastos = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			if(mov.getTipoMovimentacao() == TipoMovimentacao.GASTO) {
				gastos.add(mov);
			}
		}
		return gastos;
	}
	
	private ArrayList<Movimentacao> getGanhos(){
		
		if(this.movimentacoes == null) {
			return null;
		}
		ArrayList<Movimentacao> ganhos = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			if(mov.getTipoMovimentacao() == TipoMovimentacao.GANHO) {
				ganhos.add(mov);
			}
		}
		return ganhos;
	}

}
