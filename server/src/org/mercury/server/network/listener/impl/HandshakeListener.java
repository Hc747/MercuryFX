package org.mercury.server.network.listener.impl;

import io.netty.channel.ChannelHandlerContext;
import org.mercury.server.Constants;
import org.mercury.server.network.listener.NetworkListener;
import org.mercury.server.network.protocol.ConnectionResponse;
import org.mercury.server.network.protocol.codec.handshake.HandshakeRequest;
import org.mercury.server.network.protocol.codec.handshake.HandshakeResponse;
import org.mercury.server.network.protocol.codec.handshake.HandshakeType;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
public final class HandshakeListener implements NetworkListener {

	@Override
	public void messageRead(ChannelHandlerContext ctx, Object message) {
		if (message instanceof HandshakeRequest) {
			final HandshakeRequest request = (HandshakeRequest) message;
			final ConnectionResponse response = request.getVersion() == Constants.VERSION_MAJOR ? ConnectionResponse.SUCCESS : ConnectionResponse.OUT_OF_DATE;
			ctx.writeAndFlush(new HandshakeResponse(HandshakeType.UPDATE_CONNECTION, response));
		}
	}

}
