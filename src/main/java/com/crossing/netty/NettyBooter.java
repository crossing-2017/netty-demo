package com.crossing.netty;

import com.crossing.netty.config.NettyProperties;
import com.crossing.netty.server.WebSocketChatServer;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Component
public class NettyBooter {

  private static final String WEBSOCKET = "websocket";
  private static final String TCP = "tcp";

  /**
   * Netty属性配置
   */
  private final NettyProperties nettyProperties;

  /**
   * WebSocket服务端启动器
   */
  private final WebSocketChatServer webSocketChatServer;

  public NettyBooter(WebSocketChatServer webSocketChatServer, NettyProperties nettyProperties) {
    this.webSocketChatServer = webSocketChatServer;
    this.nettyProperties = nettyProperties;
  }

  @PostConstruct
  private void nettyServerStart() {
    if (WEBSOCKET.equalsIgnoreCase(nettyProperties.getProtocol())) {
      webSocketChatServer.start();
    }
  }
}
