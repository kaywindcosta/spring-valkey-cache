package com.kcd.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Redis cache and session management.
 * This class sets up the Redis connection factory, cache manager, and session management.
 */
@Configuration
@EnableRedisHttpSession
@EnableCaching
public class ValKey {

    @Value("${spring.redis.timeout:5s}")
    private String redisTimeout;
    @Value("${spring.redis.ttl:30}")
    private String redisTtl;

    /**
     * Configures the Redis connection factory with custom settings.
     *
     * @return LettuceConnectionFactory configured with the specified timeout.
     */
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    /**
     * Customizes the Lettuce client configuration to set the socket options.
     *
     * @return LettuceClientConfigurationBuilderCustomizer that sets the connect timeout.
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
        return clientConfigurationBuilder -> {
            clientConfigurationBuilder.clientOptions(ClientOptions.builder().socketOptions(SocketOptions.builder().connectTimeout(Duration.parse(redisTimeout)).build()).build());

//            clientConfigurationBuilder.clusterClientOptions(ClusterClientOptions.builder()
//                    .clusterSocketOptions(ClusterSocketOptions.builder().connectTimeout(Duration.parse(redisTimeout)).build())
//                    .build());
        };
    }

    /**
     * Configures the Redis cache manager with a default cache configuration.
     *
     * @param redisConnectionFactory the Redis connection factory
     * @return RedisCacheManager configured with the specified TTL for cache entries
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();

        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(Long.parseLong(redisTtl)));

        //cacheConfigurations.put("myCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)));

        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(defaultConfig).withInitialCacheConfigurations(cacheConfigurations).build();
    }


}
