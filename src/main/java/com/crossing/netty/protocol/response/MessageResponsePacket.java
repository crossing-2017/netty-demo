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
public class MessageResponsePacket extends Packet {

  @Override
  public Short getCommand() {
    return Command.MESSAGE_RESPONSE;
  }
}
