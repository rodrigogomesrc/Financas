package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Categoria;


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
	
	public Categoria getCategoria(String idCategoria) {
		for(Categoria c: this.categorias) {
			if(c.getId().equals(idCategoria)) {
				return c;
			}
		}
		return null;
	}
	
	public int getNewCategoriaId(){
		return this.categorias.size();
	}
	
	public void substituirCategoria(Categoria categoria) {
		int arrayId = 0;
		boolean achado = false;
		
		for(Categoria cat: this.categorias) {
			if(cat.getId().equals(categoria.getId())) {
				achado = true;
				break;
			}
			arrayId++;
		}
		this.categorias.set(arrayId, categoria);
		
	}

}
