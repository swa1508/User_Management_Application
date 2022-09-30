package com.app.service.impl;

import com.app.model.User;
import com.app.repository.IUserRepository;
import com.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public boolean checkUserName(String userName) {
    return userRepository.existsByUserName(userName);
  }

}
