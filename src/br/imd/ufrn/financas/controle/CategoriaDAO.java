package br.imd.ufrn.financas.controle;

import java.util.ArrayList;
import java.util.Optional;

import br.imd.ufrn.financas.modelo.Categoria;

public class CategoriaDAO {
	
	private static CategoriaDAO instancia;
	private ArrayList<Categoria> categorias;
	
	public CategoriaDAO() {
		this.categorias = new ArrayList<Categoria>();
	}
	
	public static synchronized CategoriaDAO getInstancia() {
		if (instancia == null)
			instancia = new CategoriaDAO();

		return instancia;
	}
	
	public void salvarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}
	
	public ArrayList<Categoria> getCategorias() {
		return this.categorias;
	}
	
	/*
	public Optional<Categoria> getCategoria(String categoriaId){
		
	}
	*/
	

}
