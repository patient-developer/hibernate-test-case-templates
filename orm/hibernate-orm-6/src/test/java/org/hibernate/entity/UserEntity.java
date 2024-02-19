package org.hibernate.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserAuthorities(Set<UserAuthorityEntity> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<UserAuthorityEntity> getUserAuthorities() {
        return userAuthorities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private boolean enabled;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "user",
            orphanRemoval = true)
    private Set<UserAuthorityEntity> userAuthorities = new HashSet<>();

    public void addUserAuthority(UserAuthorityEntity userAuthority) {
        this.userAuthorities.add(userAuthority);
        userAuthority.setUser(this);
    }
}
