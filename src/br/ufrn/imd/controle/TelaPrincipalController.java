package br.ufrn.imd.controle;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalController {
	
	 @FXML
	    private MenuItem mnItemCadCliente;

	    @FXML
	    private MenuItem mnItemCadFornecedor;

	    @FXML
	    private MenuItem mnItemCadProduto;

	    @FXML
	    private MenuItem mnItemListarCliente;

	    @FXML
	    private MenuItem mnItemListarFornecedor;

	    @FXML
	    private MenuItem mnItemListarProduto;

	    @FXML
	    private MenuItem mnItemSobre;

	    @FXML
	    private MenuItem mnItemSair;

	    @FXML
	    private AnchorPane ancPaneTelaPrincipal;

	    @FXML
	    void abrirTelaCliente(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaCadastroClienteController.class.getResource("/br/ufrn/imd/visao/TelaCadastroCliente.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	// Criando um novo Stage
	    	Stage clienteStage = new Stage();
	    	clienteStage.setTitle("Cadastro de Clientes");
	    	clienteStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	clienteStage.setScene(scene);
	    	
	    	// Setando o Controle 
	    	TelaCadastroClienteController controller = loader.getController();
	    	controller.setClienteStage(clienteStage);
	    	clienteStage.showAndWait();
	    }

	    @FXML
	    void abrirTelaFornecedor(ActionEvent event) {
	    	//
	    }

	    @FXML
	    void abrirTelaProduto(ActionEvent event) {
	    	//
	    }

	    @FXML
	    void fecharMainApp(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void listarCadastroClientes(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaCadastroClienteController.class.getResource("/br/ufrn/imd/visao/TelaRelatorioCliente.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	// Criando um novo Stage
	    	Stage relatorioClienteStage = new Stage();
	    	relatorioClienteStage.setTitle("Relatório de Clientes");
	    	relatorioClienteStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	relatorioClienteStage.setScene(scene);
	    	
	    	// Setando o Controle 
	    	TelaRelatorioClienteController controller = loader.getController();
	    	controller.setRelatorioClienteStage(relatorioClienteStage);
	    	relatorioClienteStage.showAndWait();
	    }

	    @FXML
	    void listarCadastroFornecedores(ActionEvent event) {
	    	//
	    }

	    @FXML
	    void listarCadastroProdutos(ActionEvent event) {
	    	//
	    }

	    @FXML
	    void listarInfo(ActionEvent event) {
	    	System.out.println("Exemplo 02 - Java FX");
	    }
}
