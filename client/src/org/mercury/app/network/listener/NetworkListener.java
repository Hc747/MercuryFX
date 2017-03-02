package org.mercury.app.network.listener;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
public interface NetworkListener {

	void messageRead(ChannelHandlerContext ctx, Object message);

}
