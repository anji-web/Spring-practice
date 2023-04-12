package com.marketplace.practice.marketplacepractice.helper;

import com.marketplace.practice.marketplacepractice.model.Users;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersDetailImpl implements UserDetails {


  private int id;
  private String username;
  private String email;
  private String password;

  private Collection<? extends  GrantedAuthority> authorities;

  public UsersDetailImpl(int id, String username, String email, String password,
                         Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static UsersDetailImpl build(Users users) {
    List<GrantedAuthority> authorities = users.getRoles()
        .stream()
        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
        .collect(Collectors.toList());

    return new UsersDetailImpl(
        users.getUserId(),
        users.getUserName(),
        users.getEmail(),
        users.getPassword(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
