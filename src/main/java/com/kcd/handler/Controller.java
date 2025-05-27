package com.kcd.handler;

import com.kcd.service.CacheService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    public final CacheService cacheService;

    /**
     * Constructor for the Controller class.
     * This constructor initializes the CacheService used for caching operations.
     *
     * @param cacheService The CacheService instance to be used by this controller.
     */
    public Controller(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * Index endpoint to return a simple greeting message.
     * This endpoint can be used to check if the application is running.
     *
     * @return A greeting message.
     */
    @GetMapping("")
    public String index() {
        log.info("Index endpoint accessed");
        return "Hello, Valkey!";
    }

    /**
     * Session endpoint to demonstrate session management.
     * This endpoint will create a new session if it does not exist.
     *
     * @param request The HTTP request object.
     * @return A message indicating whether the session is new or active.
     */
    @GetMapping("session")
    public String session(HttpServletRequest request) {
        log.info("Session endpoint accessed");
        // Check if the session is new
        if (request.getSession().isNew()) {
            // If the session is new, return a message indicating that
            request.getSession().setAttribute("message", "Welcome to your new session!");
            return "Session is new!" + request.getSession().getId();
        }
        // If the session is not new, return a message indicating that the session is active
        // You can also access session attributes if needed
        return "Session is active!" + request.getSession().getId();
    }

    /**
     * Cache endpoint to demonstrate caching functionality.
     * This endpoint will cache the response for the given key.
     *
     * @param key The key to cache the response.
     * @return A message indicating that the cache endpoint is active.
     */
    @GetMapping("cache/{key}")
    @Cacheable(value = "cache", key = "#key")
    public String cache(@PathVariable("key") String key) {
        log.info("Cache endpoint accessed with key: {}", key);
        // This endpoint can be used to demonstrate caching functionality
        return "Cache endpoint is active! " + key;
    }

    /**
     * Validate cache endpoint to check if a key exists in the cache.
     * This endpoint will return a message indicating whether the key exists in the cache.
     *
     * @param key The key to validate in the cache.
     * @return A message indicating whether the key exists in the cache.
     */
    @GetMapping("/cache/validate/{key}")
    public String validateCache(@PathVariable("key") String key) {
        log.info("Validating cache for key: {}", key);
        // This endpoint can be used to validate if a key exists in the cache
        boolean exists = cacheService.isKeyInCache("cache", key);
        return "Cache validation for key '" + key + "': " + (exists ? "Exists" : "Does not exist");
    }
}
