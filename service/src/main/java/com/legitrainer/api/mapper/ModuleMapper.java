package com.legitrainer.api.mapper;

import com.legitrainer.api.constant.AppConstant;
import com.legitrainer.api.dto.ModuleDto;
import com.legitrainer.api.entity.Module;
import org.mapstruct.Mapper;

@Mapper(componentModel = AppConstant.SPRING)
public interface ModuleMapper {
  Module dtoToEntity(ModuleDto moduleDto);

  ModuleDto entityToDto(Module module);
}
