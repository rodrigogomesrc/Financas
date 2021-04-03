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
    	
    	relMensalTextArea.setText("");
    	
    	RelatorioMensal relatorio = new RelatorioMensal();
    	String mes = this.mesTxt.getText();
    	String ano = this.anoTxt.getText();
    	
    	MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
    	relatorio.carregarMovimentacoes(dao.getGanhosMes(Integer.valueOf(mes), Integer.valueOf(ano)));
    
    	relMensalTextArea.setText(relatorio.listarGanhos());

    }

    @FXML
    void listarGanhosCategoria(ActionEvent event) {
    	
    	String mes = this.mesTxt.getText();
    	String ano = this.anoTxt.getText();
    	
    	relMensalTextArea.setText("");
		RelatorioMensal relatorio = new RelatorioMensal();
		
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		relatorio.carregarMovimentacoes(dao.getGanhosMes(Integer.valueOf(mes), Integer.valueOf(ano)));
		relMensalTextArea.setText(relatorio.getGanhosPorCategoria());
		
    }

    @FXML
    void listarGastosCategoria(ActionEvent event) {
    	
    	String mes = this.mesTxt.getText();
    	String ano = this.anoTxt.getText();
    	
    	relMensalTextArea.setText("");
		RelatorioMensal relatorio = new RelatorioMensal();
		
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		relatorio.carregarMovimentacoes(dao.getGastosMes(Integer.valueOf(mes), Integer.valueOf(ano)));
		relMensalTextArea.setText(relatorio.getGastosPorCategoria());

    }
    
    @FXML
    void listarGastos(ActionEvent event) {
    	
    	relMensalTextArea.setText("");
    	
    	RelatorioMensal relatorio = new RelatorioMensal();
    	String mes = this.mesTxt.getText();
    	String ano = this.anoTxt.getText();
    	
    	MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
    	relatorio.carregarMovimentacoes(dao.getGastosMes(Integer.valueOf(mes), Integer.valueOf(ano)));
    	relMensalTextArea.setText(relatorio.listarGastos());
    	
    }

    @FXML
    void listarInfogeral(ActionEvent event) {
    	
    	relMensalTextArea.setText("");
		Relatorio relatorio = new Relatorio();
		String mes = this.mesTxt.getText();
    	String ano = this.anoTxt.getText();
    	
		MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		relatorio.carregarMovimentacoes(dao.getMovimentacoesMes(Integer.valueOf(mes), Integer.valueOf(ano)));
		relMensalTextArea.setText(relatorio.getRelatorioGeral());
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
