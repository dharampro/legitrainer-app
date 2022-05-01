package com.legitrainer.api.service;

import com.legitrainer.api.dto.UserDto;
import com.legitrainer.api.entity.User;
import com.legitrainer.api.exception.BadRequestException;
import com.legitrainer.api.exception.ResourceNotFoundException;
import com.legitrainer.api.mapper.UserMapper;
import com.legitrainer.api.message.ErrorMessage;
import com.legitrainer.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
    if(!StringUtils.hasLength(userId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_USERID, userId));
    }
    return userMapper.entityToDto(userRepository.findByUserId(userId));
  }

  @Override
  public UserDto updateUser(UserDto userDto, String userId) {
    userDto.setUserId(userId);
    if (ObjectUtils.isEmpty(userDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_USER, userDto.toString()));
    }
    if(!StringUtils.hasLength(userId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_USERID, userId));
    }
    User user = userRepository.findByUserId(userId);
    User updatedUser = userMapper.dtoToEntity(userDto);
    updatedUser.setId(user.getId());

    if(userDto.equals(updatedUser)) {
      throw new ResourceNotFoundException(String.format(ErrorMessage.NOT_MODIFIED_USER, updatedUser.toString()));
    }
    return userMapper.entityToDto(userRepository.save(updatedUser));
  }

  @Override
  public void deleteUser(String userId) {
    userRepository.deleteByUserId(userId);
  }
}
