package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaCadastroGastoController {

	private Stage cadastroGastoStage;
	
    @FXML
    private TextField idCategoria;

    @FXML
    private TextField valorGasto;

    @FXML
    private DatePicker dataGasto;
    
    @FXML
    private Button btnCadastrar;

    @FXML
    void setData(InputMethodEvent event) {

    }

    @FXML
    void setIdCategoria(KeyEvent event) {
    	//
    }

    @FXML
    void setValorGasto(KeyEvent event) {
    	//
    }
    
    @FXML
    void cadastrar(ActionEvent event) {

    }
    
    public void setCadastroGanhoStage(Stage cadastroGastoStage) {
		this.cadastroGastoStage = cadastroGastoStage;
	}

}