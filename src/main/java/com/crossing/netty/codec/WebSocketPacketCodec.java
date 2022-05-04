package com.crossing.netty.codec;

import com.crossing.netty.protocol.Packet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Component
public class WebSocketPacketCodec extends MessageToMessageCodec<WebSocketFrame, Packet> {

  @Override
  protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet,
      List<Object> list) throws Exception {

  }

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame,
      List<Object> list) throws Exception {

  }
}
