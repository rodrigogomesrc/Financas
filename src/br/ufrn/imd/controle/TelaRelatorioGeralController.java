package br.ufrn.imd.controle;

import br.ufrn.imd.dao.MovimentacaoDAO;
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

		 relMensalTextArea.setText("");
		 Relatorio relatorio = new Relatorio();
		 MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		 relatorio.carregarMovimentacoes(dao.getMovimentacoes());
		 relMensalTextArea.setText(relatorio.getGanhosPorCategoria());
	 }

	 @FXML
	 void listarGastosCategoria(ActionEvent event) {
		 
		 relMensalTextArea.setText("");
		 Relatorio relatorio = new Relatorio();
		 MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		 relatorio.carregarMovimentacoes(dao.getMovimentacoes());
		 relMensalTextArea.setText(relatorio.getGastosPorCategoria());
	 }

	 @FXML
	 void listarGeral(ActionEvent event) {
		 
		 relMensalTextArea.setText("");
		 Relatorio relatorio = new Relatorio();
		 MovimentacaoDAO dao = MovimentacaoDAO.getInstancia();
		 relatorio.carregarMovimentacoes(dao.getMovimentacoes());
		 relMensalTextArea.setText(relatorio.getRelatorioGeral());

	 }
    
	 public void setRelatorioGeralStage(Stage relatorioGeralStage) {
		 this.relatorioGeralStage = relatorioGeralStage;
	 }

}
