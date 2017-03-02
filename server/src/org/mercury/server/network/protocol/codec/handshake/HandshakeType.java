package org.mercury.server.network.protocol.codec.handshake;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 28/2/17
 */
@RequiredArgsConstructor
public enum HandshakeType {

	LOGIN_CONNECTION(1),
	UPDATE_CONNECTION(2)
	;

	private final int opcode;

	public static HandshakeType getHandshakeType(int opcode) {
		return Arrays.stream(values()).filter(handshake -> handshake.opcode == opcode).findAny().orElse(null);
	}

}
