package com.marketplace.practice.marketplacepractice.dto;

import java.util.List;
import lombok.Data;

@Data
public class ResponseLogin {
    private String token;
    private String username;
    private List<String> roles;

  public ResponseLogin(String token, String username, List<String> roles) {
    this.token = token;
    this.username = username;
    this.roles = roles;
  }
}
