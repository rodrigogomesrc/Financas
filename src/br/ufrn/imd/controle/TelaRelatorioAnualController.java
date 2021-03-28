package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaRelatorioAnualController {
	
	private Stage relatorioAnualStage;

    @FXML
    private Button btnListarGastosCategoria;

    @FXML
    private Button btnListarGanhosCategoria;

    @FXML
    private Button btnListarGeralAno;

    @FXML
    private Button btnListarGeralPorMes;

    @FXML
    private TextArea relMensalTextArea;
    
    @FXML
    private TextField anoTxt;

    @FXML
    void listarGanhosCategoria(ActionEvent event) {

    }

    @FXML
    void listarGastosCategoria(ActionEvent event) {

    }

    @FXML
    void listarGeralAno(ActionEvent event) {

    }

    @FXML
    void listarGeralPorMes(ActionEvent event) {

    }
    
    @FXML
    void setAno(KeyEvent event) {
    	System.out.println("Ano do relatório anual: ");
    	System.out.println(anoTxt.getText());
    }
    
    public void setRelatorioAnualStage(Stage relatorioAnualStage) {
		this.relatorioAnualStage = relatorioAnualStage;
	}

}
