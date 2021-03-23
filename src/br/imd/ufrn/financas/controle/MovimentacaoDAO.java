package br.imd.ufrn.financas.controle;

public class MovimentacaoDAO {
	
private static MovimentacaoDAO instancia;
	
	public static synchronized MovimentacaoDAO getInstancia() {
		if (instancia == null)
			instancia = new MovimentacaoDAO();

		return instancia;
	}

}
