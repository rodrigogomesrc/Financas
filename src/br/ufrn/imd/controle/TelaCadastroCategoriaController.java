package br.ufrn.imd.controle;

import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.TipoMovimentacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaCadastroCategoriaController {
	
	private Stage cadastroCategoriaStage;
	private String descricao;
	private String nome;
	private TipoMovimentacao tipo = TipoMovimentacao.GASTO;

    @FXML
    private TextField nomeCategoria;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextArea descricaoCategoria;
    
    @FXML
    private RadioButton gastoToggle;

    @FXML
    private RadioButton ganhoToggle;


    @FXML
    void cadastrar(ActionEvent event) {
    	Categoria categoria = new Categoria();
    	categoria.setDescricaoCategoria(descricao);
    	categoria.setNomeCategoria(nome);
    	
    	CategoriaDAO categorias = CategoriaDAO.getInstancia();
    	categoria.setId(String.valueOf(categorias.getNewCategoriaId()));
    	categoria.setTipoCategoria(tipo);
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
    
    @FXML
    void toggleGanho(ActionEvent event) {
    	this.ganhoToggle.setSelected(true);
    	this.tipo = TipoMovimentacao.GANHO;
    	this.gastoToggle.setSelected(false);
    	
    }

    @FXML
    void toggleGasto(ActionEvent event) {
    	this.gastoToggle.setSelected(true);
    	this.tipo = TipoMovimentacao.GASTO;
    	this.ganhoToggle.setSelected(false);
    }
    
    public void setCadastroCategoriaStage(Stage cadastroCategoriaStage) {
		this.cadastroCategoriaStage = cadastroCategoriaStage;
	}

}
