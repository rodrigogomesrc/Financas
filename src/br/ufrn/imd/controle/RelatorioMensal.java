package br.ufrn.imd.controle;

import java.text.SimpleDateFormat;
import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.modelo.Movimentacao;
import br.ufrn.imd.modelo.TipoMovimentacao;

public class RelatorioMensal extends Relatorio {
	
	
	public String listarGastos() {
		return this.listarGastos(true);
	}

	public String listarGastos(Boolean header) {
		if(this.movimentacoes == null || this.movimentacoes.size() == 0) {
			return "Não há gastos para mostrar\n";
		}
		
		String output = "";
		if(header) {
			output += "********** GASTOS **********\n";
		}
		
		short itens = 0;
		
		for(Movimentacao mov: this.movimentacoes) {
			if(mov.getTipoMovimentacao() == TipoMovimentacao.GASTO) {
				output += this.formatarMovimentacao(mov);
			}
		}
		
		return output;
	}
	
	public String listarGanhos() {
		return this.listarGanhos(true);
	}
	
	public String listarGanhos(Boolean header) {
		
		if(this.movimentacoes == null || this.movimentacoes.size() == 0) {
			return "Não há ganhos para mostrar\n";
		}
		
		String output = "";
		if(header) {
			output += "********** GANHOS **********\n";
		}
		
		short itens = 0;
		
		for(Movimentacao mov: this.movimentacoes) {
			if(mov.getTipoMovimentacao() == TipoMovimentacao.GANHO) {
				output += this.formatarMovimentacao(mov);
				itens ++;
			}
		}
		
		return output;
	}
	
	private String formatarMovimentacao(Movimentacao movimentacao) {
		
		CategoriaDAO dao = CategoriaDAO.getInstancia();
		String output = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dataString = sdf.format(movimentacao.getData());
		
		output += "Data: " + dataString + "\n";
		output += "Categoria: " + dao.getCategoria(movimentacao.getCategoriaId()).getNomeCategoria() + "\n";
		output += "Valor: " + String.valueOf(movimentacao.getValorMovimentacao()) + "\n";
		output += "=============================\n";
		
		return output;
	}
}
