package org.mercury.server.network.protocol.codec.handshake;

import lombok.Value;
import org.mercury.server.network.protocol.ConnectionResponse;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
@Value
public final class HandshakeResponse {

	private final HandshakeType type;
	private final ConnectionResponse response;

}
