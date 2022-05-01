package com.legitrainer.api.entity;

import com.legitrainer.api.constant.ModelConstant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = ModelConstant.MODULE_COLLECTION)
public class Module {

  @Id
  private String id;
  @Indexed(unique = true)
  private String moduleId;
  private String title;
  private String description;
  private Set<Content> contents;
}
