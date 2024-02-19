package org.hibernate.entity;

import java.io.Serializable;

public class UserAuthorityId implements Serializable {
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public Long getUserId() {
    return userId;
  }

  public String getAuthority() {
    return authority;
  }

  private Long userId;

  private String authority;
}
