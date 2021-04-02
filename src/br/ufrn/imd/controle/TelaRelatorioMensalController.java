package br.ufrn.imd.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import br.ufrn.imd.dao.MovimentacaoDAO;
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
    	
    	RelatorioMensal relatorio = new RelatorioMensal();
    	String mes = this.mesTxt.getText();
    	MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
    	
    	//testar se o mês é realmente um número.
    	
    	if(mesTxt.getText().equals("") || mesTxt.getText() == null) {
    		return;
    	}
    	
    	//Arraylist<Movimentacao> gastosMes = dao.getGastosMes()
    	

    }

    @FXML
    void listarGastosCategoria(ActionEvent event) {
    	

    }

    @FXML
    void listarInfogeral(ActionEvent event) {

    }
    
    @FXML
    void setAno(KeyEvent event) {
    	
    }

    @FXML
    void setMes(KeyEvent event) {
    	

    }
    
    public void setRelatorioMensalStage(Stage relatorioMensalStage) {
		this.relatorioMensalStage = relatorioMensalStage;
	}

}
