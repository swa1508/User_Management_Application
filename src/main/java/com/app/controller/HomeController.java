package com.app.controller;

import javax.servlet.http.HttpSession;

import com.app.model.User;
import com.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  
  @Autowired
  private IUserService userService;
  
  @GetMapping("/")
  public String getIndexPage() {
    return "index";
  }
  @GetMapping("/login")
  public String getLoginPage() {
    return "Login";
  }
  @GetMapping("/register")
  public String getRegisterPage() {
    return "Register";
  }
  
  @PostMapping("/")
  public String registerUser(@ModelAttribute User user, HttpSession session) {
    if(userService.checkUserName(user.getUserName())) {
      session.setAttribute("msg", "Username Already exist, Please Use another one.");
    }else {
      User userDB = userService.saveUser(user);
      if(userDB != null) {
        session.setAttribute("msg", "User Created Successfully");
      }else {
        session.setAttribute("msg", "Something Went Wrong");
      }
    }
    return "redirect:/register";
  }

}
