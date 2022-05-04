package com.crossing.netty.handler;

import com.crossing.entity.User;
import com.crossing.netty.protocol.request.MessageRequestPacket;
import com.crossing.netty.protocol.response.MessageResponsePacket;
import com.crossing.netty.utils.ChannelUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Slf4j
@Component
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {


  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      MessageRequestPacket msg) throws Exception {

    // 消息发送方
    User fromUser = ChannelUtil.getUser(ctx.channel());

    // 消息接收方
    User toUser = new User(msg.getToUserId());

    // 消息响应数据包
    MessageResponsePacket messageResponsePacket = new MessageResponsePacket();

    // todo 业务逻辑

    // 消息接收方的Channel
    Channel toChannel = ChannelUtil.getChannel(toUser.getUsername());
    if (toChannel != null && ChannelUtil.hasLogin(toChannel)) {
      // 发送给消息接收方
      toChannel.writeAndFlush(messageResponsePacket);
    } else {
      log.info("username={}不在线!", toUser.getUsername());
    }
  }
}
