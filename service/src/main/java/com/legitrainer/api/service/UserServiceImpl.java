package com.legitrainer.api.service;

import com.legitrainer.api.dto.UserDto;
import com.legitrainer.api.exception.BadRequestException;
import com.legitrainer.api.mapper.UserMapper;
import com.legitrainer.api.message.ErrorMessage;
import com.legitrainer.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDto saveUser(UserDto userDto) {
    if (ObjectUtils.isEmpty(userDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_USER, userDto.toString()));
    }
    return userMapper.entityToDto(userRepository.save(userMapper.dtoToEntity(userDto)));
  }

  @Override
  public UserDto getUserById(String userId) {
    return null;
  }

  @Override
  public UserDto updateUser(UserDto userDto, String userId) {
    return null;
  }

  @Override
  public void deleteUser(String userId) {

  }
}
