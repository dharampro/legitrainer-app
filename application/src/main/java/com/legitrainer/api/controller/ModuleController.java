package com.legitrainer.api.controller;

import com.legitrainer.api.constant.ApiEndPoint;
import com.legitrainer.api.dto.ModuleDto;
import com.legitrainer.api.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndPoint.MODULE_ROOT)
public class ModuleController {

  @Autowired
  private ModuleService moduleService;

  @PostMapping
  public ResponseEntity<ModuleDto> saveModule(@RequestBody ModuleDto moduleDto) {
    return ResponseEntity.ok().body(moduleService.createModule(moduleDto));
  }

  @GetMapping(ApiEndPoint.MODULE_ID)
  public ResponseEntity<ModuleDto> getModule(@PathVariable String moduleId) {
    return ResponseEntity.ok().body(moduleService.getModule(moduleId));
  }

  @PutMapping(ApiEndPoint.MODULE_ID)
  public ResponseEntity<ModuleDto> updateModule(@RequestBody ModuleDto moduleDto, @PathVariable String moduleId) {
    return ResponseEntity.ok().body(moduleService.updateModule(moduleDto, moduleId));
  }

  @DeleteMapping(ApiEndPoint.MODULE_ID)
  public ResponseEntity deleteModule(@PathVariable String moduleId) {
    moduleService.deleteModule(moduleId);
    return ResponseEntity.ok().build();
  }
}
