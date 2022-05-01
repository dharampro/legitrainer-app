package com.legitrainer.api.mapper;

import com.legitrainer.api.constant.AppConstant;
import com.legitrainer.api.dto.SubscriptionDto;
import com.legitrainer.api.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = AppConstant.SPRING)
public interface SubscriptionMapper {
  SubscriptionDto entityToDto(Subscription subscription);

  Subscription dtoToEntity(SubscriptionDto subscriptionDto);
}
