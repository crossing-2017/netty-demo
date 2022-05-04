package com.crossing.netty.protocol.response;

import com.crossing.entity.User;
import com.crossing.netty.protocol.Packet;
import com.crossing.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 登录响应数据包
 */
@Data
public class LoginResponsePacket extends Packet {

  /**
   * 登录的用户对象
   */
  private User user;

  private Boolean success;


  @Override
  public Short getCommand() {
    return Command.LOGIN_RESPONSE;
  }

}
