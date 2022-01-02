package com.felix.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
  @Bean
  public LettuceConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName("localhost");
    redisStandaloneConfiguration.setPort(6379);

    LettuceConnectionFactory lcf = new LettuceConnectionFactory(redisStandaloneConfiguration);
    lcf.afterPropertiesSet();
    return lcf;
  }

  @Bean
  public RedisTemplate<String, Long> redisTemplate() {
    RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
    RedisSerializer stringSerializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(stringSerializer);
    redisTemplate.setKeySerializer(stringSerializer);
    redisTemplate.setValueSerializer(stringSerializer);
    redisTemplate.setHashKeySerializer(stringSerializer);
    redisTemplate.setHashValueSerializer(stringSerializer);
    redisTemplate.setConnectionFactory(redisConnectionFactory());
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }
}
