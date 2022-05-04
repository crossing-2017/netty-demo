package com.crossing.netty.server;

import com.crossing.netty.config.NettyProperties;
import com.crossing.netty.initializer.WebSocketServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description websocket服务器
 */
@Component
public class WebSocketChatServer {

  private final WebSocketServerInitializer webSocketServerInitializer;
  private int port;

  public WebSocketChatServer(NettyProperties nettyProperties,
      WebSocketServerInitializer webSocketServerInitializer) {
    this.port = nettyProperties.getWebsocket().getPort();
    this.webSocketServerInitializer = webSocketServerInitializer;
  }

  public void start() {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    ServerBootstrap serverBootstrap = new ServerBootstrap();
    serverBootstrap
        .group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .childHandler(webSocketServerInitializer);

    serverBootstrap.bind(port).addListener((ChannelFutureListener) future -> {
      if (future.isSuccess()) {
        System.out.println("websocket端口绑定成功 port = " + port);
      } else {
        System.out.println("websocket端口绑定失败");
      }
    });
  }
}
