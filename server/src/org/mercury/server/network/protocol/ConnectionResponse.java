package org.mercury.server.network.protocol;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
@Getter
@RequiredArgsConstructor
public enum ConnectionResponse {

	SUCCESS(1),
	OUT_OF_DATE(2)
	;

	private final int response;

}
