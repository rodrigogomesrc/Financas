package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TelaRelatorioGeralController {
	
	private Stage relatorioGeralStage;

	 @FXML
	    private Button btnListarGastosCategoria;

	    @FXML
	    private Button btnListarGanhosCategoria;

	    @FXML
	    private Button btnListarGeral;

	    @FXML
	    private TextArea relMensalTextArea;

	    @FXML
	    void listarGanhosCategoria(ActionEvent event) {

	    }

	    @FXML
	    void listarGastosCategoria(ActionEvent event) {

	    }

	    @FXML
	    void listarGeral(ActionEvent event) {

	    }
    
    public void setRelatorioGeralStage(Stage relatorioGeralStage) {
		this.relatorioGeralStage = relatorioGeralStage;
	}

}
