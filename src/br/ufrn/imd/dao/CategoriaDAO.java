package br.ufrn.imd.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.DadosCSV;


public class CategoriaDAO implements DadosCSV{
	
	private static CategoriaDAO instancia;
	private ArrayList<Categoria> categorias;
	
	public CategoriaDAO() {
		this.categorias = new ArrayList<Categoria>();
		this.lerDados();
	
	}
	
	public static synchronized CategoriaDAO getInstancia() {
		if (instancia == null)
			instancia = new CategoriaDAO();

		return instancia;
	}
	
	public void salvarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
		this.salvarDados();
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
		this.salvarDados();
	}

	@Override
	public void salvarDados() {
		
		try {
			FileWriter csvWriter = new FileWriter("categoria.csv");
			for(Categoria cat: this.categorias) {
				csvWriter.append(cat.getId());
				csvWriter.append(",");
				csvWriter.append(cat.getNomeCategoria());
				csvWriter.append(",");
				csvWriter.append(cat.getDescricaoCategoria());
				csvWriter.append("\n");
			}
			
			csvWriter.flush();
			csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void lerDados() {
		
		String row;
		BufferedReader csvReader;
		
		try {
			csvReader = new BufferedReader(new FileReader("categoria.csv"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    Categoria categoria = new Categoria();
			    categoria.setId(data[0]);
			    categoria.setNomeCategoria(data[1]);
			    categoria.setDescricaoCategoria(data[2]);
			    this.salvarCategoria(categoria);
			}
			
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
