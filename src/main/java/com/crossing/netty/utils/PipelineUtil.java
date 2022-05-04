package com.crossing.netty.utils;

import com.crossing.netty.handler.AuthHandler;
import com.crossing.netty.handler.HeartBeatRequestHandler;
import com.crossing.netty.handler.LoginRequestHandler;
import com.crossing.netty.handler.LogoutRequestHandler;
import com.crossing.netty.handler.MessageRequestHandler;
import io.netty.channel.ChannelPipeline;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description  ChannelPipeline工具类
 */
@Component
public class PipelineUtil {

  /**
   * 心跳检测
   */
  @Resource
  private HeartBeatRequestHandler heartBeatRequestHandler;

  /**
   * 身份校验
   */
  @Resource
  private AuthHandler authHandler;

  /**
   * 登录
   */
  @Resource
  private LoginRequestHandler loginRequestHandler;

  /**
   * 退出登录
   */
  @Resource
  private LogoutRequestHandler logoutRequestHandler;

  /**
   * 单聊消息
   */
  @Resource
  private MessageRequestHandler messageRequestHandler;

  public void addHandler(ChannelPipeline pipeline) {
    pipeline.addLast(
        heartBeatRequestHandler,
        loginRequestHandler,
        authHandler,
        logoutRequestHandler,
        messageRequestHandler
    );
  }
}
