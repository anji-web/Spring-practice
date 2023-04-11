package com.marketplace.practice.marketplacepractice.services;

import com.marketplace.practice.marketplacepractice.helper.UsersDetailImpl;
import com.marketplace.practice.marketplacepractice.model.Users;
import com.marketplace.practice.marketplacepractice.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersDetailsServices implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users users = usersRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    return UsersDetailImpl.build(users);
  }

}
