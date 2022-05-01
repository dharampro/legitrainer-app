package com.legitrainer.api.entity;

import com.legitrainer.api.constant.ModelConstant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Document(collection = ModelConstant.COURSE_COLLECTION)
public class Course {
  @Id
  private String id;

  @Indexed(unique = true)
  private String courseId;
  private String title;
  private String description;

  @NotNull
  private Integer length;

  @NotNull
  private String thumbnail;
  private Set<String> moduleIds;
}
