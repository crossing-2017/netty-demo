package com.crossing.netty.config;

import com.crossing.entity.User;
import io.netty.util.AttributeKey;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description 用于缓存到 channel 中的属性的键
 */
public interface Attributes {

  AttributeKey<User> USER_ATTRIBUTE_KEY = AttributeKey.newInstance("user");
}
