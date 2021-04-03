package br.ufrn.imd.controle;

import br.ufrn.imd.dao.MovimentacaoDAO;
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
    private TextArea relAnualTextArea;
    
    @FXML
    private TextField anoTxt;

    @FXML
    void listarGanhosCategoria(ActionEvent event) {
    	
    	relAnualTextArea.setText("");
		RelatorioAnual relatorio = new RelatorioAnual();
		relatorio.setAno(Integer.valueOf(this.anoTxt.getText()));
		relAnualTextArea.setText(relatorio.getGanhosPorCategoria());
    }

    @FXML
    void listarGastosCategoria(ActionEvent event) {

    	relAnualTextArea.setText("");
		RelatorioAnual relatorio = new RelatorioAnual();
		relatorio.setAno(Integer.valueOf(this.anoTxt.getText()));
		relAnualTextArea.setText(relatorio.getGastosPorCategoria());
    }

    @FXML
    void listarGeralAno(ActionEvent event) {

    	relAnualTextArea.setText("");
		RelatorioAnual relatorio = new RelatorioAnual();
		relatorio.setAno(Integer.valueOf(this.anoTxt.getText()));
		relAnualTextArea.setText(relatorio.getRelatorioGeral());
    }

    @FXML
    void listarGeralPorMes(ActionEvent event) {
    	
    	relAnualTextArea.setText("");
		RelatorioAnual relatorio = new RelatorioAnual();
		relatorio.setAno(Integer.valueOf(this.anoTxt.getText()));
		relAnualTextArea.setText(relatorio.relatorioGeralPorMes());

    }
    
    @FXML
    void setAno(KeyEvent event) {
    	
    }
    
    public void setRelatorioAnualStage(Stage relatorioAnualStage) {
		this.relatorioAnualStage = relatorioAnualStage;
	}

}
