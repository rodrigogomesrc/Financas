package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaCadastroCategoriaController {
	
	private Stage cadastroCategoriaStage;

    @FXML
    private TextField nomeCategoria;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextArea descricaoCategoria;

    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void setDescricao(KeyEvent event) {

    }

    @FXML
    void setNomeCategoria(KeyEvent event) {

    }
    
    public void setCadastroCategoriaStage(Stage cadastroCategoriaStage) {
		this.cadastroCategoriaStage = cadastroCategoriaStage;
	}

}
