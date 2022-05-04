package com.crossing.netty.initializer;

import com.crossing.netty.codec.WebSocketPacketCodec;
import com.crossing.netty.config.NettyProperties;
import com.crossing.netty.handler.MyIdleStateHandler;
import com.crossing.netty.utils.PipelineUtil;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Component
public class WebSocketServerInitializer extends ChannelInitializer<NioSocketChannel> {

  @Autowired
  private PipelineUtil pipelineUtil;

  @Autowired
  private WebSocketPacketCodec webSocketPacketCodec;


  /**
   * websocket路径
   */
  private String websocketPath;

  /**
   * 最大内容长度
   */
  private int maxContentLength;

  public WebSocketServerInitializer(NettyProperties nettyProperties) {
    this.websocketPath = nettyProperties.getWebsocket().getPath();
    this.maxContentLength = nettyProperties.getWebsocket().getHttpObjectAggregator()
        .getMaxContentLength();
  }

  @Override
  protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

    ChannelPipeline pipeline = nioSocketChannel.pipeline();
    pipeline.addLast(new HttpServerCodec());
    pipeline.addLast(new ChunkedWriteHandler());
    pipeline.addLast(new HttpObjectAggregator(maxContentLength));
    pipeline.addLast(new WebSocketServerProtocolHandler(websocketPath));

    nioSocketChannel.pipeline().addLast(new MyIdleStateHandler());
    nioSocketChannel.pipeline().addLast(webSocketPacketCodec);
    pipelineUtil.addHandler(pipeline);
  }
}
