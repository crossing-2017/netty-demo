package com.crossing.netty.handler;

import com.crossing.netty.protocol.request.HeartBeatRequestPacket;
import com.crossing.netty.protocol.response.HeartBeatResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 心跳检测
 */
@Component
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket msg) throws Exception {
    ctx.writeAndFlush(new HeartBeatResponsePacket());
  }
}
