package com.crossing.netty.protocol.command;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 指令
 */
public interface Command {

  Short HEART_BEAT_REQUEST = 1000;
  Short HEART_BEAT_RESPONSE = 1001;

  Short LOGIN_REQUEST = 2000;
  Short LOGIN_RESPONSE = 2001;

  Short LOGOUT_REQUEST = 2002;
  Short LOGOUT_RESPONSE = 2003;

  Short MESSAGE_REQUEST = 3000;
  Short MESSAGE_RESPONSE = 3001;

}
