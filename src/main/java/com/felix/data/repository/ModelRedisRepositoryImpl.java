package com.felix.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ModelRedisRepositoryImpl implements ModelRedisRepository {
  @Autowired private RedisTemplate<String, Long> redisTemplate;

  public Double findModelByKey(String key) {

    HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();

    Optional<String> model;
    String model1 = (String) hashOperations.get("model", key);
    model = Optional.of(Optional.ofNullable(model1).orElse("0"));
    Double number = Double.valueOf(model.get());

    return number;
  }
}
