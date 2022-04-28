package com.legitrainer.api.controller;

import com.legitrainer.api.constant.ApiEndPoints;
import com.legitrainer.api.dto.UserDto;
import com.legitrainer.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndPoints.USER_ROOT)
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
    return ResponseEntity.ok().body(userService.saveUser(userDto));
  }
}
