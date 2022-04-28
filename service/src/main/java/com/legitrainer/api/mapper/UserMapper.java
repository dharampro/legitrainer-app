package com.legitrainer.api.mapper;

import com.legitrainer.api.constant.AppConstant;
import com.legitrainer.api.dto.UserDto;
import com.legitrainer.api.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = AppConstant.SPRING)
public interface UserMapper {
  User dtoToEntity(UserDto userDto);

  UserDto entityToDto(User user);
}
