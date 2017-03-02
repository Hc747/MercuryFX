package org.mercury.server.network.protocol.codec.handshake;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.java.Log;
import org.mercury.server.network.protocol.ConnectionResponse;

import java.util.List;

import static org.mercury.server.network.protocol.DataType.INT;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
@Log
public final class HandshakeDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
		if (buffer.isReadable()) {
			final HandshakeType type = HandshakeType.getHandshakeType(buffer.readUnsignedByte());
			if (type != null) {

				log.info("Type: "+type.toString());

				switch (type) {
					case LOGIN_CONNECTION:
						ctx.writeAndFlush(new HandshakeResponse(type, ConnectionResponse.SUCCESS));
						break;
					case UPDATE_CONNECTION:
						if (buffer.isReadable(INT.bytesRequired())) {
							final int version = buffer.readInt();
							out.add(new HandshakeRequest(version));
						}
						break;
				}
			}
		}
	}

}
