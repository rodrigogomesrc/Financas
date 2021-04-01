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

public class TelaEditarCategoriaController {
	
	private Stage edicaoCategoriaStage;
	private String descricao;
	private String id;
	private String nome;

    @FXML
    private TextField nomeCategoria;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextArea descricaoCategoria;

    @FXML
    private TextField idCategoria;

    @FXML
    void cadastrar(ActionEvent event) {
    	CategoriaDAO dao = CategoriaDAO.getInstancia();
    	Categoria categoria = dao.getCategoria(this.id);
    	
    	//Caso o id da categoria não exista, não faz nada
    	if(categoria == null) {
    		return;
    	}
    	
    	Categoria novaCategoria = new Categoria();
    	novaCategoria.setId(this.id);
    	novaCategoria.setDescricaoCategoria(this.descricao);
    	novaCategoria.setNomeCategoria(this.nome);
    	
    	//Limpar campos
    	this.idCategoria.setText("");
    	this.descricaoCategoria.setText("");
    	this.nomeCategoria.setText("");
    	dao.substituirCategoria(novaCategoria);
    	
    }

    @FXML
    void setDescricao(KeyEvent event) {
    	this.descricao = this.descricaoCategoria.getText();
    }

    @FXML
    void setIdCategoria(KeyEvent event) {
    	this.id = this.idCategoria.getText();
    }

    @FXML
    void setNomeCategoria(KeyEvent event) {
    	this.nome = this.nomeCategoria.getText();
    }
    
    public void setEdicaoCategoriaStage(Stage edicaoCategoriaStage) {
		this.edicaoCategoriaStage = edicaoCategoriaStage;
	}

}
