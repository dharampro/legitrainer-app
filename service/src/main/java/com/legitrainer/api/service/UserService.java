package com.legitrainer.api.service;

import com.legitrainer.api.dto.UserDto;

public interface UserService {

  UserDto saveUser(UserDto userDto);

  UserDto getUserById(String userId);

  UserDto updateUser(UserDto userDto, String userId);

  void deleteUser(String userId);
}
