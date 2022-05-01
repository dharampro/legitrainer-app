package com.legitrainer.api.service;

import com.legitrainer.api.dto.SubscriptionDto;
import com.legitrainer.api.entity.Subscription;
import com.legitrainer.api.exception.BadRequestException;
import com.legitrainer.api.mapper.SubscriptionMapper;
import com.legitrainer.api.message.ErrorMessage;
import com.legitrainer.api.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

  @Autowired
  private SubscriptionRepository subscriptionRepository;

  @Autowired
  private SubscriptionMapper subscriptionMapper;

  @Override
  public SubscriptionDto createSubscription(SubscriptionDto subscriptionDto) {
    if (ObjectUtils.isEmpty(subscriptionDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_SUBSCRIPTION, subscriptionDto.toString()));
    }
    return subscriptionMapper.entityToDto(subscriptionRepository.save(subscriptionMapper.dtoToEntity(subscriptionDto)));
  }

  @Override
  public SubscriptionDto getSubscription(String subscriptionId) {
    if (!StringUtils.hasLength(subscriptionId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_SUBSCRIPTIONID, subscriptionId));
    }
    return subscriptionMapper.entityToDto(subscriptionRepository.findBySubscriptionId(subscriptionId));
  }

  @Override
  public SubscriptionDto updateSubscription(SubscriptionDto subscriptionDto, String subscriptionId) {
    subscriptionDto.setSubscriptionId(subscriptionId);
    if (ObjectUtils.isEmpty(subscriptionDto)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_SUBSCRIPTION, subscriptionDto.toString()));
    }
    if (!StringUtils.hasLength(subscriptionId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_SUBSCRIPTIONID, subscriptionId));
    }
    Subscription subscriptionDb = subscriptionRepository.findBySubscriptionId(subscriptionId);
    Subscription updatedSubscription = subscriptionMapper.dtoToEntity(subscriptionDto);
    updatedSubscription.setId(subscriptionDb.getId());
    if (ObjectUtils.isEmpty(updatedSubscription)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_SUBSCRIPTION, subscriptionDto.toString()));
    }
    return subscriptionMapper.entityToDto(subscriptionRepository.save(updatedSubscription));
  }

  @Override
  public void deleteSubscription(String subscriptionId) {
    if (!StringUtils.hasLength(subscriptionId)) {
      throw new BadRequestException(String.format(ErrorMessage.BAD_REQUEST_SUBSCRIPTIONID, subscriptionId));
    }
    subscriptionRepository.deleteBySubscriptionId(subscriptionId);
  }
}
