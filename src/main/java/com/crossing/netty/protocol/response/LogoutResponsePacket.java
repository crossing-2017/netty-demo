package com.crossing.netty.protocol.response;

import com.crossing.netty.protocol.Packet;
import com.crossing.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Data
public class LogoutResponsePacket extends Packet {

  private Boolean success;

  @Override
  public Short getCommand() {
    return Command.LOGOUT_RESPONSE;
  }
}
