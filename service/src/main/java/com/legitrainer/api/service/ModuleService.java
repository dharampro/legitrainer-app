package com.legitrainer.api.service;

import com.legitrainer.api.dto.ModuleDto;

public interface ModuleService {
  ModuleDto createModule(ModuleDto moduleDto);

  ModuleDto getModule(String moduleId);

  ModuleDto updateModule(ModuleDto moduleDto, String moduleId);

  void deleteModule(String moduleId);
}
