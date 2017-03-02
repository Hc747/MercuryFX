package org.mercury.app.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
public final class NetworkReactor {

	private final EventLoopGroup worker = new NioEventLoopGroup(2);
	private final Bootstrap bootstrap = new Bootstrap();

	public NetworkReactor() {
		bootstrap
				.group(worker)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.option(ChannelOption.SO_KEEPALIVE, true)
				.handler(new ChannelInitializer<NioSocketChannel>() {
					@Override
					protected void initChannel(NioSocketChannel channel) throws Exception {
						final ChannelPipeline pipeline = channel.pipeline();
						//TODO
						//encoder
						//decoder
						pipeline.addLast("handler", new NetworkHandler(channel));
					}
				});
	}

	public ChannelFuture connect(String hostname, int port) {
		return bootstrap.connect(hostname, port);
	}

	public void shutdown() throws Exception {
		worker.shutdownGracefully();
	}

}
