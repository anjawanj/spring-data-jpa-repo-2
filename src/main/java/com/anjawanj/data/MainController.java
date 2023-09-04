package com.anjawanj.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {
  @Autowired
  private UserService userService;

  @PostMapping(path="/add")
  public @ResponseBody Iterable<User> addNewUser (@RequestBody User user) {
    userService.addNewUser(user.getName(),user.getEmail());
    return userService.getAllUsers();
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userService.getAllUsers();
  }
}