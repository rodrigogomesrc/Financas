package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.modelo.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TelaListarCategoriaController {
	
	private Stage listagemCategoriaStage;

    @FXML
    private Button btnListar;

    @FXML
    private TextArea listagemCategorias;

    @FXML
    void listarCategorias(ActionEvent event) {
    	
    	this.listagemCategorias.setText("");
    	
    	CategoriaDAO categoriasDAO = CategoriaDAO.getInstancia();
    	ArrayList<Categoria> categorias = categoriasDAO.getCategorias();
    	
    	String output = "";
    	for(Categoria cat: categorias) {
    		output += "=============================\n";
    		output += "Id: " + cat.getId() + "\n";
    		output += "Nome: " + cat.getNomeCategoria() + "\n";
    		output += "Descricao: " + cat.getDescricaoCategoria() + "\n";
    		output += "\n";
    	}
    	
    	if(categorias.size() > 0) {
    		output += "=============================\n";
    	}
    	
    	this.listagemCategorias.setText(output);
    }
    
    public void setListagemCategoriaStage(Stage listagemCategoriaStage) {
		this.listagemCategoriaStage = listagemCategoriaStage;
	}

}
