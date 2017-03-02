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
		/*final Task<ChannelFuture> connect = Task.callable("connect", () -> {
			final ChannelFuture future = reactor.connect("127.0.0.1", 43595);
			future.addListener(connection -> {
				Preconditions.checkArgument(connection.isSuccess(), "Could not reach the server!");
				System.out.println("Connected to the server!");
			});
			future.channel().closeFuture().addListener(close -> {
				System.out.println("Connection to the server closed!");
			});
			return future;
		});
		engine.getEngine().run(connect);*/

		/*final String hostname = "127.0.0.1";
		final int port = 43595;
		final ChannelFuture future = reactor.connect("127.0.0.1", 43595);
		future.addListener(connection -> {
			System.out.println(String.format("Reactor %ssuccessfully connected to %s:%d", connection.isSuccess() ? "" : "un", hostname, port));
			if (connection.isSuccess()) {
				future.channel().closeFuture().addListener(close -> System.out.println("Connection to the server was lost!"));
			}
		});*/
	}

	@Override
	public void start(Stage stage) throws IOException {
		final Parent root = FXMLLoader.load(getClass().getResource("views/login/login.fxml"));
		stage.setTitle("Mercury");
		stage.setResizable(false);

		final Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

		/*final Task<ChannelFuture> connect = Task.value("connect", reactor.connect("127.0.0.1", 43595));
		final Task<ChannelFuture> onConnection = connect.andThen(future -> {
			future.addListener(connection -> {
				Preconditions.checkArgument(connection.isSuccess(), "Could not reach the server!");
				System.out.println("Connected to the server!");
			});
			future.channel().closeFuture().addListener(close -> {
				System.out.println("Connection to the server closed!");
			});
		});


		engine.getEngine().run(onConnection);*/
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
