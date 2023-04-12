package com.marketplace.practice.marketplacepractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

  private String username;
  private String email;
  private String password;

  private String roleName;
}
