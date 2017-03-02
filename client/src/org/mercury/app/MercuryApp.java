package org.mercury.app;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.mercury.app.engine.TaskEngine;
import org.mercury.app.network.NetworkReactor;

import java.io.IOException;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 23/2/17
 */
@Getter
public final class MercuryApp extends Application {

	private final NetworkReactor reactor = new NetworkReactor();
	private final TaskEngine engine = new TaskEngine();

	@Override
	public void init() {

	}

	@Override
	public void start(Stage stage) throws IOException {
		final Parent root = FXMLLoader.load(getClass().getResource("views/login/login.fxml"));
		stage.setTitle("Mercury");
		stage.setResizable(false);

		final Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();
	}

	@Override
	public void stop() throws Exception {
		engine.shutdown();
		reactor.shutdown();
	}

	public static void main(String[] args) {
		LauncherImpl.launchApplication(MercuryApp.class, MercuryPreloader.class, args);
	}
}
