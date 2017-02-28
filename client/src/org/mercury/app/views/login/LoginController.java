package org.mercury.app.views.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.mercury.app.controllers.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 23/2/17
 */
public final class LoginController implements Initializable {

	private static final Predicate<String> INPUT_VALIDATION = input -> !input.trim().isEmpty();

	private final Controller loginEvent = new Controller() {
		@Override
		public boolean validate() {
			return INPUT_VALIDATION.test(username.getText()) && INPUT_VALIDATION.test(password.getText()) && INPUT_VALIDATION.test(shelter.getText());
		}

		@Override
		public void execute() {

		}
	};

	@FXML
	private Button login;

	@FXML
	private TextField username;

	@FXML
	private TextField shelter;

	@FXML
	private PasswordField password;

	@FXML
	private Hyperlink recovery;

	@FXML
	private Hyperlink help;

	@FXML
	private void login() {
		/*System.out.println("Login event!");
		System.out.println(String.format("Username: %s, Password: %s", username.getText(), password.getText()));
		if (!INPUT_VALIDATION.test(username.getText())) {
			username.requestFocus();
		} else if (!PASSWORD_VALIDATION.test(password.getText())) {
			password.requestFocus();
		} else {
			System.out.println("Perform login procedure!");
		}*/
	}

	@FXML
	private void recover() {
		/*try {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().browse(new URI("https://www.google.com"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		login.setDisable(true);
		login.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				event.consume();
				login();
			}
		});
		username.setOnKeyTyped(event -> {
			username.getOnKeyTyped();
			login.setDisable(!loginEvent.validate());
		});
		password.setOnKeyTyped(event -> {
			password.getOnKeyTyped();
			login.setDisable(!loginEvent.validate());
		});

		shelter.setOnKeyTyped(event -> {
			shelter.getOnKeyTyped();
			login.setDisable(!loginEvent.validate());
		});
	}

}
