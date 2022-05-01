package com.legitrainer.api.mapper;

import com.legitrainer.api.constant.AppConstant;
import com.legitrainer.api.dto.CourseDto;
import com.legitrainer.api.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = AppConstant.SPRING)
public interface CourseMapper {
  CourseDto entityToDto(Course course);

  Course dtoToEntity(CourseDto courseDto);
}
