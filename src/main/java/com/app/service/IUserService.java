package com.app.service;

import com.app.model.User;

public interface IUserService {

  User saveUser(User user);
  public boolean checkUserName(String userName);

}
