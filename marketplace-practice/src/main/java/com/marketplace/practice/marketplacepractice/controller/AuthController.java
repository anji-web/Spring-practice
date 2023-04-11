package com.marketplace.practice.marketplacepractice.controller;

import com.marketplace.practice.marketplacepractice.config.JwtUtils;
import com.marketplace.practice.marketplacepractice.dto.ResponseLogin;
import com.marketplace.practice.marketplacepractice.dto.SignInDTO;
import com.marketplace.practice.marketplacepractice.dto.SignUpDTO;
import com.marketplace.practice.marketplacepractice.helper.UsersDetailImpl;
import com.marketplace.practice.marketplacepractice.model.Role;
import com.marketplace.practice.marketplacepractice.model.Users;
import com.marketplace.practice.marketplacepractice.repo.RoleRepository;
import com.marketplace.practice.marketplacepractice.repo.UsersRepository;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  private UsersRepository usersRepository;


  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("signin")
  public ResponseEntity signIn(@RequestBody SignInDTO signInDTO) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(signInDTO.getUsername(), signInDTO.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwtToken = jwtUtils.generateJwtToken(authentication);
    UsersDetailImpl userDetails = (UsersDetailImpl) authentication.getPrincipal();

    List<String> roles = userDetails.getAuthorities().stream().map(item-> item.getAuthority()).collect(
        Collectors.toList());

    return ResponseEntity.ok(new ResponseLogin(jwtToken, userDetails.getUsername(), roles));

  }

  @PostMapping("signup")
  public ResponseEntity signUp(@RequestBody SignUpDTO signUpDTO){

    if (usersRepository.existsByUserName(signUpDTO.getUsername())){
        return ResponseEntity.badRequest().body("User already exists");
    }

    if (usersRepository.existsByEmail(signUpDTO.getEmail())){
      return ResponseEntity.badRequest().body("Email already exists");
    }

    Users users = new Users();
    users.setUserName(signUpDTO.getUsername());
    users.setEmail(signUpDTO.getEmail());
    users.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
    users.setCreated_at(new Date());
    users.setUpdated_at(new Date());

    Role role = roleRepository.findByRoleName(signUpDTO.getRoleName())
          .orElseThrow(() -> new RuntimeException("Role not found"));

    Set<Role> roles = new HashSet<>();
    roles.add(role);

    users.setRoles(roles);

    usersRepository.save(users);

    return ResponseEntity.status(HttpStatus.CREATED).body("regitstration successfully");

  }

}
