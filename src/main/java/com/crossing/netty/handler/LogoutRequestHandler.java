package com.crossing.netty.handler;

import com.crossing.netty.protocol.request.LogoutRequestPacket;
import com.crossing.netty.protocol.response.LogoutResponsePacket;
import com.crossing.netty.utils.ChannelUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Component
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      LogoutRequestPacket logoutRequestPacket) throws Exception {

    ChannelUtil.unBindUser(ctx.channel());

    LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
    logoutResponsePacket.setSuccess(true);
    ctx.channel().writeAndFlush(logoutResponsePacket);
  }
}
