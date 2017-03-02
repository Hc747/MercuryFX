package org.mercury.server.network.protocol;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
public enum DataType {

	BYTE,
	SHORT,
	INT,
	LONG
	;

	public int bytesRequired() {
		return 1 << ordinal();
	}

}
