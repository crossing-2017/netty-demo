package com.crossing.netty.protocol;

import lombok.Data;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 数据包抽象基类
 */
@Data
public abstract class Packet {

  /**
   * 协议版本
   */
  private Byte version = 1;

  /**
   * 获取指令
   *
   * @return
   */
  public abstract Short getCommand();

}
