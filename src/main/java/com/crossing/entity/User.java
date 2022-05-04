package com.crossing.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Crossing
 * @date 2022-05-04
 * @description
 */
@Data
@NoArgsConstructor
public class User {

  private String username;

  private Integer userId;

  public User(Integer userId) {
    this.userId = userId;
  }

}
