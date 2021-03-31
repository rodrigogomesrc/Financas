package br.ufrn.imd.controle;

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

    }
    
    public void setListagemCategoriaStage(Stage listagemCategoriaStage) {
		this.listagemCategoriaStage = listagemCategoriaStage;
	}

}
