package br.ufrn.imd.controle;

import br.ufrn.imd.dao.MovimentacaoDAO;

public class RelatorioAnual extends Relatorio {

	private int ano;
	
	@Override
	public String getGanhosPorCategoria() {

		Relatorio relatorio = new Relatorio();
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		
		String output = "********** GANHOS POR CATEGORIA POR MÊS **********\n";
		for(int i = 1; i <= 12; i++) {
			String mesString = "============= " +  this.getNomeMes(i) + " =============\n";
			relatorio.carregarMovimentacoes(dao.getGanhosMes(i, this.ano));
			output += "\n";
			output += mesString;
			output += relatorio.getGanhosPorCategoria(false);
		}
		
		return output;
	}

	@Override
	public String getGastosPorCategoria() {
		
		Relatorio relatorio = new Relatorio();
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		
		String output = "********** GASTOS POR CATEGORIA POR MÊS **********\n";
		for(int i = 1; i <= 12; i++) {
			String mesString = "============= " +  this.getNomeMes(i) + " =============\n";
			relatorio.carregarMovimentacoes(dao.getGastosMes(i, this.ano));
			output += "\n";
			output += mesString;
			output += relatorio.getGastosPorCategoria(false);
		}
		
		return output;
	}

	@Override
	public String getRelatorioGeral() {
		
		Relatorio relatorio = new Relatorio();
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		
		String output = "********** RELATÓRIO GERAL ANUAL**********\n";
		relatorio.carregarMovimentacoes(dao.getMovimentacoesAno(this.ano));
		output += relatorio.getRelatorioGeral(false);
		return output;	
	}
	
	public String relatorioGeralPorMes() {
		Relatorio relatorio = new Relatorio();
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		
		String output = "********** RELATÓRIO GERAL POR MÊS **********\n";
		for(int i = 1; i <= 12; i++) {
			String mesString = "============= " +  this.getNomeMes(i) + " =============\n";
			relatorio.carregarMovimentacoes(dao.getGastosMes(i, this.ano));
			output += "\n";
			output += mesString;
			output += relatorio.getRelatorioGeral(false);
		}
		
		return output;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	private String getNomeMes(int numeroMes) {
		switch (numeroMes) {
			case 1:
				return "Janeiro";
			case 2:
				return "Fevereiro";
			case 3:
				return "Março";
			case 4:
				return "Abril";
			case 5:
				return "Maio";
			case 6:
				return "Junho";
			case 7:
				return "Julho";
			case 8:
			    return "Agosto";
			case 9:
			    return "Setembro";
			case 10:
			    return "Outubro";
			case 11:
			    return "Novembro";
			case 12:
			    return "Dezembro";
			default:
				return "Mês inválido";
		}
	}

}
