package br.ufrn.imd.controle;

import br.ufrn.imd.dao.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TelaRelatorioClienteController {
	
	Banco bc;
	
	private Stage relatorioclienteStage;
	private boolean btnConfirmarClicked = false;
	
	@FXML
    private Button btnFecharRelatorioCliente;
	
	@FXML
    private Button btnListarCadastroCliente;
	
	@FXML
    private TextArea txaRelarotioClientes;


    @FXML
    void fecharRelatorioCliente(ActionEvent event) {
    	// 
    }
    
    @FXML
    void listarCadastroCliente(ActionEvent event) {
    	bc = Banco.getInstance();
		String lines = bc.listarClientes();
		txaRelarotioClientes.setText(txaRelarotioClientes.getText() + "\n" + lines);
    }

	public void setRelatorioClienteStage(Stage relatorioClienteStage) {
		this.relatorioclienteStage = relatorioClienteStage;
	}

}
