package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.TipoMovimentacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TelaListarCategoriaController {
	
	private Stage listagemCategoriaStage;

    @FXML
    private Button btnListarGastos;

    @FXML
    private TextArea listagemCategorias;

    @FXML
    private Button btnListarGanhos;

    @FXML
    void listarCategoriasGanhos(ActionEvent event) {
    	
    	this.listagemCategorias.setText("");
    	
    	CategoriaDAO categoriasDAO = CategoriaDAO.getInstancia();
    	ArrayList<Categoria> categorias = categoriasDAO.getCategorias();
    	
    	String output = "********** CATEGORIAS GANHOS **********\n";
    	for(Categoria cat: categorias) {
    		
    		if(cat.getTipoCategoria() == TipoMovimentacao.GASTO) {
    			continue;
    		}
    		
    		output += "Id: " + cat.getId() + "\n";
    		output += "Nome: " + cat.getNomeCategoria() + "\n";
    		output += "Descricao: " + cat.getDescricaoCategoria() + "\n";
    		output += "\n";
    		output += "=============================\n";
    	}
    	
    	this.listagemCategorias.setText(output);

    }

    @FXML
    void listarCategoriasGastos(ActionEvent event) {
    	
    	this.listagemCategorias.setText("");
    	
    	CategoriaDAO categoriasDAO = CategoriaDAO.getInstancia();
    	ArrayList<Categoria> categorias = categoriasDAO.getCategorias();
    	
    	String output = "********** CATEGORIAS GASTO **********\n";
    	for(Categoria cat: categorias) {
    		
    		if(cat.getTipoCategoria() == TipoMovimentacao.GANHO) {
    			continue;
    		}
    		
    		output += "Id: " + cat.getId() + "\n";
    		output += "Nome: " + cat.getNomeCategoria() + "\n";
    		output += "Descricao: " + cat.getDescricaoCategoria() + "\n";
    		output += "\n";
    		output += "=============================\n";
    	}
    	
    	this.listagemCategorias.setText(output);

    }
    
    public void setListagemCategoriaStage(Stage listagemCategoriaStage) {
		this.listagemCategoriaStage = listagemCategoriaStage;
	}

}

