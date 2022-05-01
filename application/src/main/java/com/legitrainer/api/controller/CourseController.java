package com.legitrainer.api.controller;

import com.legitrainer.api.constant.ApiEndPoint;
import com.legitrainer.api.dto.CourseDto;
import com.legitrainer.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndPoint.COURSE_ROOT)
public class CourseController {

  @Autowired
  private CourseService courseService;

  @PostMapping
  public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
    return ResponseEntity.ok().body(courseService.createCourse(courseDto));
  }

  @GetMapping(ApiEndPoint.COURSE_ID)
  public ResponseEntity<CourseDto> getCourse(@PathVariable String courseId) {
    return ResponseEntity.ok().body(courseService.getCourse(courseId));
  }

  @PutMapping(ApiEndPoint.COURSE_ID)
  public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable String courseId) {
    return ResponseEntity.ok().body(courseService.updateCourse(courseDto, courseId));
  }

  @DeleteMapping(ApiEndPoint.COURSE_ID)
  public ResponseEntity deleteCourse(@PathVariable String courseId) {
    courseService.deleteByCourseId(courseId);
    return ResponseEntity.ok().build();
  }
}
