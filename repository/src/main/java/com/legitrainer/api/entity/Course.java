package com.legitrainer.api.entity;

import com.legitrainer.api.constant.ModelConstant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = ModelConstant.COURSE_COLLECTION)
public class Course {
  @Id
  private String id;
  private String courseId;
  private String title;
  private String description;
  private Integer length;
  private String thumbnail;
  private Set<String> moduleIds;
}
