package com.crossing.netty.utils;

import com.crossing.entity.User;
import com.crossing.netty.config.Attributes;
import io.netty.channel.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description channel工具类
 */
@Slf4j
public class ChannelUtil {

  /**
   * username -> Channel 的映射集合   可以用redis代替
   */
  private static final Map<String, Channel> USER_ID_CHANNEL_MAP = new ConcurrentHashMap<>();

  public static void bindUser(User user, Channel channel) {
    USER_ID_CHANNEL_MAP.put(user.getUsername(), channel);
    channel.attr(Attributes.USER_ATTRIBUTE_KEY).set(user);
  }

  public static void unBindUser(Channel channel) {
    if (hasLogin(channel)) {
      USER_ID_CHANNEL_MAP.remove(getUser(channel).getUsername());
      channel.attr(Attributes.USER_ATTRIBUTE_KEY).set(null);
    }
  }

  public static boolean hasLogin(Channel channel) {
    return channel.hasAttr(Attributes.USER_ATTRIBUTE_KEY);
  }

  public static User getUser(Channel channel) {
    return channel.attr(Attributes.USER_ATTRIBUTE_KEY).get();
  }

  public static Channel getChannel(String username) {
    return USER_ID_CHANNEL_MAP.get(username);
  }

}
