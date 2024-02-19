package org.hibernate.entity;

import jakarta.persistence.*;

@Entity
@IdClass(UserAuthorityId.class)
@Table(name = "user_authorities")
public class UserAuthorityEntity {

  @Id
  @Column(name = "user_id")
  private Long userId;

  @Id
  @Column(name = "authority")
  private String authority;

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  private UserEntity user;

  public Long getUserId() {
    return userId;
  }

  public String getAuthority() {
    return authority;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}
