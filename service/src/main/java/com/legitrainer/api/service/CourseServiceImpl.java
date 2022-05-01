package com.legitrainer.api.service;

import com.legitrainer.api.dto.CourseDto;
import com.legitrainer.api.entity.Course;
import com.legitrainer.api.exception.BadRequestException;
import com.legitrainer.api.exception.ResourceNotModifiedException;
import com.legitrainer.api.mapper.CourseMapper;
import com.legitrainer.api.message.ErrorMessage;
import com.legitrainer.api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private CourseMapper courseMapper;

  @Override
  public CourseDto createCourse(CourseDto courseDto) {
    if (ObjectUtils.isEmpty(courseDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_COURSE, courseDto.toString()));
    }
    return courseMapper.entityToDto(courseRepository.save(courseMapper.dtoToEntity(courseDto)));
  }

  @Override
  public CourseDto getCourse(String courseId) {
    if (!StringUtils.hasLength(courseId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_COURSEID, courseId));
    }
    return courseMapper.entityToDto(courseRepository.findByCourseId(courseId));
  }

  @Override
  public CourseDto updateCourse(CourseDto courseDto, String courseId) {
    courseDto.setCourseId(courseId);
    if (ObjectUtils.isEmpty(courseDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_COURSE, courseDto.toString()));
    }
    if (!StringUtils.hasLength(courseId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_COURSEID, courseId));
    }
    Course courseDb = courseRepository.findByCourseId(courseId);
    Course courseUpdated = courseMapper.dtoToEntity(courseDto);
    courseUpdated.setId(courseDb.getId());
    if (courseDb.equals(courseUpdated)) {
      throw new ResourceNotModifiedException(String.format(ErrorMessage.NOT_MODIFIED_COURSE, courseUpdated.toString()));
    }
    return courseMapper.entityToDto(courseRepository.save(courseUpdated));
  }

  @Override
  public void deleteByCourseId(String courseId) {
    if (!StringUtils.hasLength(courseId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_COURSEID, courseId));
    }
    courseRepository.deleteByCourseId(courseId);
  }
}
