package org.mercury;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 23/2/17
 */
public final class Mercury extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		final Parent root = FXMLLoader.load(getClass().getResource("views/login/login.fxml"));
		stage.setTitle("Mercury");
		stage.setResizable(false);

		final Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
