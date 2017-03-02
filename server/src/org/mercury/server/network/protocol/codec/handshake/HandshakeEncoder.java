package org.mercury.server.network.protocol.codec.handshake;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.java.Log;
import org.mercury.server.network.NetworkHandler;
import org.mercury.server.network.protocol.ConnectionResponse;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
@Log
public final class HandshakeEncoder extends MessageToByteEncoder<HandshakeResponse> {

	@Override
	protected void encode(ChannelHandlerContext ctx, HandshakeResponse message, ByteBuf output) throws Exception {
		final ConnectionResponse response = message.getResponse();
		final ChannelPipeline pipeline = ctx.channel().pipeline();

		output.writeByte(response.getResponse());

		log.info("Response: " + response.toString());

		if (response == ConnectionResponse.SUCCESS) {

			log.info("Type: "+message.getType().toString());

			switch (message.getType()) {
				case LOGIN_CONNECTION:
					ctx.channel().attr(NetworkHandler.CURRENT_LISTENER);//.set(new LoginListener());
					//pipeline.addAfter("decoder", "login.encoder", new LoginEncoder());
					//pipeline.replace("decoder", "login.decoder", new LoginDecoder());
					break;
				case UPDATE_CONNECTION:
					ctx.channel().attr(NetworkHandler.CURRENT_LISTENER);//.set(new UpdateListener());
					//pipeline.addAfter("decoder", "update.encoder", new UpdateEncoder());
					//pipeline.replace("decoder", "update.decoder", new UpdateDecoder());
					break;
			}
		}
		pipeline.remove(this);
	}

}
