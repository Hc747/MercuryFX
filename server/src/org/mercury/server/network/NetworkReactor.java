package org.mercury.server.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.mercury.server.network.protocol.codec.handshake.HandshakeDecoder;
import org.mercury.server.network.protocol.codec.handshake.HandshakeEncoder;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 28/2/17
 */
public final class NetworkReactor {

	private final EventLoopGroup boss, worker;
	private final ServerBootstrap bootstrap = new ServerBootstrap();

	public NetworkReactor() {
		this(new NioEventLoopGroup(1), new NioEventLoopGroup());
	}

	public NetworkReactor(EventLoopGroup boss, EventLoopGroup worker) {
		this.boss = boss;
		this.worker = worker;
	}

	public ChannelFuture bootstrap(int port) {
		bootstrap
				.group(boss, worker)
				.channel(NioServerSocketChannel.class)
				.childOption(ChannelOption.TCP_NODELAY, true)
				.childOption(ChannelOption.SO_KEEPALIVE, true)
				.childHandler(new ChannelInitializer<NioSocketChannel>() {
					@Override
					protected void initChannel(NioSocketChannel channel) throws Exception {
						final ChannelPipeline pipeline = channel.pipeline();
						pipeline.addLast("encoder", new HandshakeEncoder());
						pipeline.addLast("decoder", new HandshakeDecoder());
						pipeline.addLast("handler", new NetworkHandler(channel));
					}
				});
		return bootstrap.bind(port);
	}

	public void shutdown() throws Exception {
		worker.shutdownGracefully();
		boss.shutdownGracefully();
	}

}
