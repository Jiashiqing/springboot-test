package com.baidu.uuap.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * RedisConnectionFactory配置
 * maxInactiveIntervalInSeconds设置session失效时间60s
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class RedisHttpSessionConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.session.redis", ignoreUnknownFields = true)
    public RedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        return connectionFactory;
    }
}
