package com.conexasaude.service;

import com.conexasaude.entity.UserEntity;
import com.conexasaude.usecases.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired private UserServiceImpl userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final UserEntity userEntity = userService.findByUsername(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException(username);
    }
    UserDetails user =
        User.withUsername(userEntity.getUsername())
            .password(userEntity.getPassword())
            .authorities(userEntity.getRoles().name())
            .build();
    return user;
  }
}
