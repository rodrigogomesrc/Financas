package br.ufrn.imd.controle;

import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.modelo.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaCadastroCategoriaController {
	
	private Stage cadastroCategoriaStage;
	private String descricao;
	private String nome;

    @FXML
    private TextField nomeCategoria;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextArea descricaoCategoria;

    @FXML
    void cadastrar(ActionEvent event) {
    	Categoria categoria = new Categoria();
    	categoria.setDescricaoCategoria(descricao);
    	categoria.setNomeCategoria(nome);
    	
    	CategoriaDAO categorias = CategoriaDAO.getInstancia();
    	categoria.setId(String.valueOf(categorias.getNewCategoriaId()));
    	categorias.salvarCategoria(categoria);
    	
    	this.nomeCategoria.setText("");
    	this.descricaoCategoria.setText("");
    }

    @FXML
    void setDescricao(KeyEvent event) {
    	this.descricao = descricaoCategoria.getText();
    }

    @FXML
    void setNomeCategoria(KeyEvent event) {
    	this.nome = this.nomeCategoria.getText();
    }
    
    public void setCadastroCategoriaStage(Stage cadastroCategoriaStage) {
		this.cadastroCategoriaStage = cadastroCategoriaStage;
	}

}
