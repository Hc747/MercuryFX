package org.mercury.server.network;

import com.google.common.base.Preconditions;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.java.Log;
import org.mercury.server.network.listener.NetworkListener;
import org.mercury.server.network.listener.impl.HandshakeListener;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
@Log
public final class NetworkHandler extends ChannelInboundHandlerAdapter {

	public static final AttributeKey<NetworkListener> CURRENT_LISTENER = AttributeKey.valueOf("listener");

	NetworkHandler(Channel channel) {
		channel.attr(CURRENT_LISTENER).set(new HandshakeListener());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object message) {
		try {
			log.info("Channel read!");
			final NetworkListener listener = Preconditions.checkNotNull(ctx.channel().attr(CURRENT_LISTENER).get(), "Network listener is not permitted to be null.");
			if (ctx.channel().isRegistered()) {
				listener.messageRead(ctx, message);
			}
		} finally {
			ReferenceCountUtil.release(message);
		}
	}

}
