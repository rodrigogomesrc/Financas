package br.ufrn.imd.controle;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaCadastroGanhoController {

	private Stage cadastroGanhoStage;
	
    @FXML
    private TextField idCategoria;

    @FXML
    private TextField valorGanho;

    @FXML
    private DatePicker dataGanho;

    @FXML
    void setData(InputMethodEvent event) {

    }

    @FXML
    void setIdCategoria(KeyEvent event) {

    }

    @FXML
    void setValorGanho(KeyEvent event) {

    }
    
    public void setCadastroGanhoStage(Stage cadastroGanhoStage) {
		this.cadastroGanhoStage = cadastroGanhoStage;
	}

}
