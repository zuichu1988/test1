package com.mhrj.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 配置类
 */
@Configuration
public class JedisConfig extends CachingConfigurerSupport {
    private Logger LOGGER = LoggerFactory.getLogger(JedisConfig.class);
    @Autowired
    private RedisConfigProperties redisConfigProperties;

    @Bean(name = "jedisPoolConfig")
    @ConfigurationProperties(prefix = "spring.redis.pool-config")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }
    @Bean(name = "jedisPool")
    public JedisPool jedisPool(@Qualifier(value = "jedisPoolConfig") final JedisPoolConfig jedisPoolConfig) {
        LOGGER.info("Jedis Pool build start ");
        String host = redisConfigProperties.getHost();
        Integer timeout = redisConfigProperties.getTimeout();
        int port = redisConfigProperties.getPort();
        String password = redisConfigProperties.getPassword();
        int database = redisConfigProperties.getDatabase();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
        LOGGER.info("Jedis Pool build success  host={} , port={}", host, port);
        return jedisPool;
    }
}