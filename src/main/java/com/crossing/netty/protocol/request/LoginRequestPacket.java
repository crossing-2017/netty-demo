package com.crossing.netty.protocol.request;

import com.crossing.netty.protocol.Packet;
import com.crossing.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 登录请求数据包
 */
@Data
public class LoginRequestPacket extends Packet {

  @Override
  public Short getCommand() {
    return Command.LOGIN_REQUEST;
  }

}
