package org.mercury.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 23/2/17
 */
public final class LoginController implements Initializable {

	private static final Predicate<String> USERNAME_VALIDATION = username -> !username.trim().isEmpty();
	private static final Predicate<String> PASSWORD_VALIDATION = password -> !password.trim().isEmpty();

	@FXML
	private Button login;

	@FXML
	private TextField username;

	@FXML
	private TextField auth;

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
		if (!USERNAME_VALIDATION.test(username.getText())) {
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
		login.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				event.consume();
				login();
			}
		});
	}

}
