package com.crossing.netty.handler;

import com.alibaba.fastjson.JSON;
import com.crossing.entity.User;
import com.crossing.netty.protocol.request.LoginRequestPacket;
import com.crossing.netty.protocol.response.LoginResponsePacket;
import com.crossing.netty.utils.ChannelUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 登录请求逻辑处理器
 */
@Slf4j
@Component
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      LoginRequestPacket loginRequestPacket) throws Exception {

    LoginResponsePacket loginResponsePacket = new LoginResponsePacket();

    User user = new User();

    log.info("登录成功,user={}", JSON.toJSONString(user));
    // 保存用户信息和channel对应关系
    ChannelUtil.bindUser(user, ctx.channel());

    loginResponsePacket.setUser(user);
    loginResponsePacket.setSuccess(true);
    ctx.channel().writeAndFlush(loginResponsePacket);
  }
}
