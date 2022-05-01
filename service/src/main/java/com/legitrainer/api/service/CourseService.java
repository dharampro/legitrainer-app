package com.legitrainer.api.service;

import com.legitrainer.api.dto.CourseDto;

public interface CourseService {
  CourseDto createCourse(CourseDto courseDto);

  CourseDto getCourse(String courseId);

  CourseDto updateCourse(CourseDto courseDto, String courseId);

  void deleteByCourseId(String courseId);
}
