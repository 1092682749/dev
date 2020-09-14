package com.dyz.dev.configuration.cache;

import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.MapCacheImpl;
import com.dyz.dev.utils.cache.RedisCacheImpl;
import com.dyz.dev.utils.cache.SessionCacheImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

@Configuration
public class CacheConfiguration {
    @Value("${app.cache.type}")
    private String type;
    @Autowired
    RedisStandaloneConfiguration redisStandaloneConfiguration;
    @Bean
    public CacheUtils determineCacheType() {
        if ("redis".equals(type)) {
            return new RedisCacheImpl(redisStandaloneConfiguration);
        }
        if ("map".equals(type)) {
          return new MapCacheImpl();
        }
        return new SessionCacheImpl();
    }
}
