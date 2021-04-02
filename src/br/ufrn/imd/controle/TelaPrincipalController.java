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
    	relatorioGeralStage.setTitle("Relatorio Geral");
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
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroGastoController.class.getResource("/br/ufrn/imd/visao/TelaCadastroGasto.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage cadastroGastoStage = new Stage();
    	cadastroGastoStage.setTitle("Cadastro de Gasto");
    	cadastroGastoStage.setResizable(false);
    	Scene scene = new Scene(page);
    	cadastroGastoStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroGastoController controller = loader.getController();
    	controller.setCadastroGanhoStage(cadastroGastoStage);
    	cadastroGastoStage.showAndWait();
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
    void abrirTelaCadastroCategoria(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroCategoriaController.class.getResource("/br/ufrn/imd/visao/TelaCadastroCategoria.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage cadastroCategoriaStage = new Stage();
    	cadastroCategoriaStage.setTitle("Cadastro de Categoria");
    	cadastroCategoriaStage.setResizable(false);
    	Scene scene = new Scene(page);
    	cadastroCategoriaStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroCategoriaController controller = loader.getController();
    	controller.setCadastroCategoriaStage(cadastroCategoriaStage);
    	cadastroCategoriaStage.showAndWait();
    }

    @FXML
    void abrirTelaEditarCategoria(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaEditarCategoriaController.class.getResource("/br/ufrn/imd/visao/TelaEdicaoCategoria.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage edicaoCategoriaStage = new Stage();
    	edicaoCategoriaStage.setTitle("Editar Categoria");
    	edicaoCategoriaStage.setResizable(false);
    	Scene scene = new Scene(page);
    	edicaoCategoriaStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaEditarCategoriaController controller = loader.getController();
    	controller.setEdicaoCategoriaStage(edicaoCategoriaStage);
    	edicaoCategoriaStage.showAndWait();
    }
    
    @FXML
    void abrirTelaListarCategorias(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaListarCategoriaController.class.getResource("/br/ufrn/imd/visao/TelaListagemCategorias.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage listagemCategoriaStage = new Stage();
    	listagemCategoriaStage.setTitle("Listar Categorias");
    	listagemCategoriaStage.setResizable(false);
    	Scene scene = new Scene(page);
    	listagemCategoriaStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaListarCategoriaController controller = loader.getController();
    	controller.setListagemCategoriaStage(listagemCategoriaStage);
    	listagemCategoriaStage.showAndWait();
    }

}
