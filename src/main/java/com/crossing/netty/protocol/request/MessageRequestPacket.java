package com.crossing.netty.protocol.request;

import com.crossing.netty.protocol.Packet;
import com.crossing.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 客户端发送至服务端的消息数据包
 */
@Data
public class MessageRequestPacket extends Packet {

  private Integer toUserId;

  @Override
  public Short getCommand() {
    return Command.MESSAGE_REQUEST;
  }

}
