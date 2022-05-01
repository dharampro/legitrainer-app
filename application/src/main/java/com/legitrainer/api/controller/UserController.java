package com.legitrainer.api.controller;

import com.legitrainer.api.constant.ApiEndPoint;
import com.legitrainer.api.dto.UserDto;
import com.legitrainer.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndPoint.USER_ROOT)
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
    return ResponseEntity.ok().body(userService.saveUser(userDto));
  }

  @GetMapping(ApiEndPoint.USER_ID)
  public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
    return ResponseEntity.ok().body(userService.getUserById(userId));
  }

  @PutMapping(ApiEndPoint.USER_ID)
  public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable String userId) {
    return ResponseEntity.ok().body(userService.updateUser(userDto, userId));
  }

  @DeleteMapping(ApiEndPoint.USER_ID)
  public ResponseEntity deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
    return ResponseEntity.ok().build();
  }
}
