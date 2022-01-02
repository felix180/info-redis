package com.felix.data.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ModelRedisRepository {
    Double findModelByKey(String key);
}
