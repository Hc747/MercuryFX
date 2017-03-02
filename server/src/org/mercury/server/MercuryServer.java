package org.mercury.server;

import com.google.common.base.Preconditions;
import io.netty.channel.ChannelFuture;
import org.mercury.server.network.NetworkReactor;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 28/2/17
 */
public final class MercuryServer {

	private final NetworkReactor reactor = new NetworkReactor();

	public void launch(int port) {
		final ChannelFuture bootstrap = reactor.bootstrap(port);
		bootstrap.addListener(success -> {
			Preconditions.checkArgument(success.isSuccess(), String.format("Could not bound %s on port %d!", Constants.APPLICATION_NAME, port));
			System.out.println(String.format("%s successfully bound on port %d!", Constants.APPLICATION_NAME, port));
		});
		bootstrap.channel().closeFuture().addListener(close -> {
			System.out.println(String.format("%s unbound on port %d", Constants.APPLICATION_NAME, port));
			reactor.shutdown();
		});
	}

	public static void main(String[] args) throws InterruptedException {
		new MercuryServer().launch(43595);
	}

}
