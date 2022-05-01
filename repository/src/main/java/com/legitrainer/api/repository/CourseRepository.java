package com.legitrainer.api.repository;

import com.legitrainer.api.entity.Course;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

  Course findByCourseId(String courseId);

  @DeleteQuery
  void deleteByCourseId(String courseId);

}
