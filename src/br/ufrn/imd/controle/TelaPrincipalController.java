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
    private MenuItem mnItemRelatorioMensal;

    @FXML
    private MenuItem mnItemRelatorioAnual;

    @FXML
    private MenuItem mnItemRelatorioGeral;

    @FXML
    private MenuItem mnItemCadastrarGasto;

    @FXML
    private MenuItem mnItemCadastrarGanho;

    @FXML
    private MenuItem mnItemCadastrarCategoria;

    @FXML
    private MenuItem mnItemEditarCategoria;

    @FXML
    private MenuItem mnItemListarCategorias;

    @FXML
    private AnchorPane ancPaneTelaPrincipal;
    

    @FXML
    void abrirTelaRelatorioMensal(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaRelatorioMensalController.class.getResource("/br/ufrn/imd/visao/TelaRelatorioMensal.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage relatorioMensalStage = new Stage();
    	relatorioMensalStage.setTitle("Relatorio Mensal");
    	relatorioMensalStage.setResizable(false);
    	Scene scene = new Scene(page);
    	relatorioMensalStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaRelatorioMensalController controller = loader.getController();
    	controller.setRelatorioMensalStage(relatorioMensalStage);
    	relatorioMensalStage.showAndWait();
    }

    @FXML
    void abrirTelaRelatorioAnual(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaRelatorioAnualController.class.getResource("/br/ufrn/imd/visao/TelaRelatorioAnual.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage relatorioAnualStage = new Stage();
    	relatorioAnualStage.setTitle("Relatorio Geral");
    	relatorioAnualStage.setResizable(false);
    	Scene scene = new Scene(page);
    	relatorioAnualStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaRelatorioAnualController controller = loader.getController();
    	controller.setRelatorioAnualStage(relatorioAnualStage);
    	relatorioAnualStage.showAndWait();
    }

    @FXML
    void abrirTelaRelatorioGeral(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaRelatorioGeralController.class.getResource("/br/ufrn/imd/visao/TelaRelatorioGeral.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage relatorioGeralStage = new Stage();
    	relatorioGeralStage.setTitle("Relatorio Mensal");
    	relatorioGeralStage.setResizable(false);
    	Scene scene = new Scene(page);
    	relatorioGeralStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaRelatorioGeralController controller = loader.getController();
    	controller.setRelatorioGeralStage(relatorioGeralStage);
    	relatorioGeralStage.showAndWait();
    }

    /*
    @FXML
    void fecharMainApp(ActionEvent event) {
    	System.exit(0);
    }
    */

    @FXML
    void abrirTelaCadastroGasto(ActionEvent event) throws IOException {
    	
    	/*
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroClienteController.class.getResource("/br/ufrn/imd/visao/TelaRelatorioCliente.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage relatorioClienteStage = new Stage();
    	relatorioClienteStage.setTitle("Relat�rio de Clientes");
    	relatorioClienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	relatorioClienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaRelatorioClienteController controller = loader.getController();
    	controller.setRelatorioClienteStage(relatorioClienteStage);
    	relatorioClienteStage.showAndWait();
    	*/
    }
    
    @FXML
    void abrirTelaCadastroGanho(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroGanhoController.class.getResource("/br/ufrn/imd/visao/TelaCadastroGanho.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage cadastroGanhoStage = new Stage();
    	cadastroGanhoStage.setTitle("Cadastro de Ganho");
    	cadastroGanhoStage.setResizable(false);
    	Scene scene = new Scene(page);
    	cadastroGanhoStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroGanhoController controller = loader.getController();
    	controller.setCadastroGanhoStage(cadastroGanhoStage);
    	cadastroGanhoStage.showAndWait();
    	
    }


    @FXML
    void abrirTelaCadastroCategoria(ActionEvent event) {
    	//
    }

    @FXML
    void abrirTelaEditarCategoria(ActionEvent event) {
    	//
    }
    
    @FXML
    void abrirTelaListarCategorias(ActionEvent event) {
    	//
    }

}
