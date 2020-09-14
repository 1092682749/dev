package com.dyz.dev.utils.cache;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class MapCacheImpl implements CacheUtils {
  private    Map<String, Object> cachePool = new HashMap<>();
  @Override
  public void put(String key, Object value, HttpServletRequest request) throws NoSupportCacheType {
    cachePool.put(key, value);
  }

  @Override
  public Object get(String key, HttpServletRequest request) throws NoSupportCacheType {
    return cachePool.get(key);
  }

  @Override
  public void remove(String key, HttpServletRequest request) {
    cachePool.remove(key);
  }
}
