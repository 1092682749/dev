package com.dyz.dev.utils.cache;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class RedisCacheImpl implements CacheUtils {
  private RedisTemplate<String, Object> redisTemplate;

  public RedisCacheImpl(RedisStandaloneConfiguration configuration) {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
    LettuceConnectionFactory redisConnectionFactory = new LettuceConnectionFactory(configuration);
    redisConnectionFactory.afterPropertiesSet();
    redisTemplate = new RedisTemplate<>();
    StringRedisSerializer redisSerializer = new StringRedisSerializer();
    JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
    redisTemplate.setKeySerializer(redisSerializer);
    redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
    redisTemplate.setHashKeySerializer(redisSerializer);
    redisTemplate.setHashValueSerializer(jdkSerializationRedisSerializer);
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.afterPropertiesSet();
  }

  @Override
  public void put(String key, Object value, HttpServletRequest request) throws NoSupportCacheType {
    String token = getToken(request);

    redisTemplate.opsForHash().put(token, key, value);
    redisTemplate.expire(token, 600, TimeUnit.MINUTES);
  }

  public void put(String key, String hashKey, Object value) throws NoSupportCacheType {
    redisTemplate.opsForHash().put(key, hashKey, value);
  }

  public Object get(String key, HttpServletRequest request) throws NoSupportCacheType {
    String token = getToken(request);
    if (token == null) return null;
    redisTemplate.expire(token, 600, TimeUnit.MINUTES);
    return redisTemplate.opsForHash().get(token, key);
  }

  @Override
  public void remove(String key, HttpServletRequest request) {
    redisTemplate.delete(key);
  }

  @Override
  public void login(String key, Object value, HttpServletRequest request, HttpServletResponse response) throws NoSupportCacheType {
    // hmap 是在这里创建的
    redisTemplate.expire(key, 600, TimeUnit.MINUTES);
    redisTemplate.opsForHash().put(key, key, value);
  }
  @Override
   public String getToken(HttpServletRequest request) {
    String token = "";
    // 前后端分离项目，只需要把token返回给前端，前端会把token写到header里。因此获取token方式为header里拿；
    token = request.getHeader("token");
    return token;
  }



}
