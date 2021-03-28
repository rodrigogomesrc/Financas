package br.ufrn.imd.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class TelaRelatorioMensalController {
	
	private Stage relatorioMensalStage;

    @FXML
    private Button btnListarGastos;

    @FXML
    private Button btnListarGanhos;

    @FXML
    private Button btnListarGastosCategoria;

    @FXML
    private Button btnListarGanhosCategoria;

    @FXML
    private Button btnListarInfoGeral;

    @FXML
    private TextArea relMensalTextArea;
    
    @FXML
    private TextField mesTxt;

    @FXML
    private TextField anoTxt;


    @FXML
    void listarGanhos(ActionEvent event) {

    }

    @FXML
    void listarGanhosCategoria(ActionEvent event) {

    }

    @FXML
    void listarGastos(ActionEvent event) {

    }

    @FXML
    void listarGastosCategoria(ActionEvent event) {

    }

    @FXML
    void listarInfogeral(ActionEvent event) {

    }
    
    @FXML
    void setAno(KeyEvent event) {
    	System.out.println("testando mostrar o texto do ano: ");
    	System.out.println(anoTxt.getText());
    }

    @FXML
    void setMes(KeyEvent event) {
    	System.out.println("testando mostrar o texto do mês: ");
    	System.out.println(mesTxt.getText());

    }
    
    public void setRelatorioMensalStage(Stage relatorioMensalStage) {
		this.relatorioMensalStage = relatorioMensalStage;
	}

}
