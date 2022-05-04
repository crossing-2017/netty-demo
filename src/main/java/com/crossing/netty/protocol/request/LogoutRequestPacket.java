package com.crossing.netty.protocol.request;

import com.crossing.netty.protocol.Packet;
import com.crossing.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Data
public class LogoutRequestPacket extends Packet {

  @Override
  public Short getCommand() {
    return Command.LOGOUT_REQUEST;
  }
}
