package com.legitrainer.api.service;

import com.legitrainer.api.dto.ModuleDto;
import com.legitrainer.api.entity.Module;
import com.legitrainer.api.exception.BadRequestException;
import com.legitrainer.api.mapper.ModuleMapper;
import com.legitrainer.api.message.ErrorMessage;
import com.legitrainer.api.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class ModuleServiceImpl implements ModuleService {

  @Autowired
  private ModuleRepository moduleRepository;

  @Autowired
  private ModuleMapper moduleMapper;

  @Override
  public ModuleDto createModule(ModuleDto moduleDto) {
    if (ObjectUtils.isEmpty(moduleDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_MODULE, moduleDto.toString()));
    }
    return moduleMapper.entityToDto(moduleRepository.save(moduleMapper.dtoToEntity(moduleDto)));
  }

  @Override
  public ModuleDto getModule(String moduleId) {
    if (!StringUtils.hasLength(moduleId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_MODULEID, moduleId));
    }
    return moduleMapper.entityToDto(moduleRepository.findByModuleId(moduleId));
  }

  @Override
  public ModuleDto updateModule(ModuleDto moduleDto, String moduleId) {
    moduleDto.setModuleId(moduleId);
    if (ObjectUtils.isEmpty(moduleDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_MODULE, moduleDto.toString()));
    }
    if (!StringUtils.hasLength(moduleId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_MODULEID, moduleId));
    }
    Module moduleDb = moduleRepository.findByModuleId(moduleId);
    Module updatedModule = moduleMapper.dtoToEntity(moduleDto);
    updatedModule.setId(moduleDb.getId());
    if (ObjectUtils.isEmpty(updatedModule)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_MODULE, updatedModule.toString()));
    }
    return moduleMapper.entityToDto(moduleRepository.save(updatedModule));
  }

  @Override
  public void deleteModule(String moduleId) {
    if (!StringUtils.hasLength(moduleId)) {
      throw new BadRequestException(String.format(ErrorMessage.NOT_MODIFIED_MODULE, moduleId));
    }
    moduleRepository.deleteByModuleId(moduleId);
  }
}
