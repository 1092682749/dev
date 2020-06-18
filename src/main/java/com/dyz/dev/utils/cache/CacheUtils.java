package com.dyz.dev.utils.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CacheUtils {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    public void put(String key, Object value, Long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
        redisTemplate.opsForValue().set(key, value);
    }

    public void put(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 30, TimeUnit.MINUTES);

    }

    public <T> T get(String key, Class<T> cla) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(key);
        return cla.cast(valueOperations.get(key));
    }
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
