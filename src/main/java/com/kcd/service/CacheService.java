package com.kcd.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    /**
     * CacheManager to manage cache operations.
     */
    private final CacheManager cacheManager;

    /**
     * Constructor for the CacheService class.
     * This constructor initializes the CacheManager used for cache operations.
     *
     * @param cacheManager The CacheManager instance to be used by this service.
     */
    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * Retrieves a value from the specified cache by key.
     *
     * @param cacheName the name of the cache
     * @param key       the key to look up
     * @return the value associated with the key, or null if not found
     */
    public boolean isKeyInCache(String cacheName, String key) {
        log.info("Checking if key '{}' exists in cache '{}'", key, cacheName);
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            return cache.get(key) != null;
        }
        return false;
    }
}