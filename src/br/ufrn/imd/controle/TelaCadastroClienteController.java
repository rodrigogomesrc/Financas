package br.ufrn.imd.controle;

import java.util.Date;

import br.ufrn.imd.dao.Banco;
import br.ufrn.imd.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroClienteController {
	
	private Stage clienteStage;
	private boolean btnConfirmarClicked = false;
	
	Banco bc;
	
	@FXML
    private Label lbIdCliente;

    @FXML
    private Label lbNomeCliente;

    @FXML
    private Label lbCPFCliente;

    @FXML
    private Label lbDtNasCliente;

    @FXML
    private TextField tfIdCliente;

    @FXML
    private TextField tfNomeCliente;

    @FXML
    private TextField tfCPFCliente;

    @FXML
    private DatePicker dtPickerDtNasCliente;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;
    

    public boolean isBtnConfirmarClicked() {
		return btnConfirmarClicked;
	}

	public void setBtnConfirmarClicked(boolean btnConfirmarClicked) {
		this.btnConfirmarClicked = btnConfirmarClicked;
	}

	@FXML
    void cancelarCliente(ActionEvent event) {
    	clienteStage.close();
    }

    @FXML
    void inserirCliente(ActionEvent event) {
    	
    	btnConfirmarClicked = true;
    	
    	if (btnConfirmarClicked){
    		// Pegar os dados de Cliente
    		bc = Banco.getInstance();
    		
    		// buscando último cliente
    		int cod = bc.buscaCodigoCliente();
    		cod++;
    		
    		// setar atributos Cliente
    		Cliente c = new Cliente();
    		c.setIdCliente(cod);
    		
    		c.setNomeCliente(tfNomeCliente.getText());
    		
    		c.setCpf(tfCPFCliente.getText());
    		
    		// pegar a data do DatePicker
    		Date data = new Date(dtPickerDtNasCliente.getValue().toEpochDay());
    		c.setDataNascimento(data);
    		
    		// persistir dados
    		bc.inserirCliente(c);
    	}
    	clienteStage.close();
    }

	public void setClienteStage(Stage clienteStage) {
		this.clienteStage = clienteStage;
	}

}
