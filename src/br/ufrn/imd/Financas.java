package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Financas extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// caminho da Tela Principal
			Parent root = FXMLLoader.load(getClass().getResource("visao/TelaPrincipal.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Gerenciador de Finanças");
			stage.setResizable(false);
			stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
