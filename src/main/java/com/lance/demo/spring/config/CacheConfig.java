package com.lance.demo.spring.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * Created by perdonare on 2017/5/11.
 */
@Configuration
@EnableCaching //add for spring abstraction cache support and cache annotation
@EnableRedisRepositories //add for redis repositories support
public class CacheConfig {
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("192.168.1.72");
        connectionFactory.setPort(6379);
        return connectionFactory;
    }



    @Bean
    Jackson2HashMapper jackson2HashMapper() {
        return new Jackson2HashMapper(false);//warning the difference between normal mapping and flat mapping
    }

   /* @Bean   //string key
    public StringRedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        return new StringRedisTemplate(jedisConnectionFactory);
    }*/

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String,Object> redisTemplate =  new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }


    @Bean
    RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate );
    }

   /* @Bean
    public KeyGenerator paymentKeyGenerator(){
        return (target, method, params) -> {

        };
    }*/

    //@Bean
    public RedisConnectionFactory jedisConnectionFactory_sentinel() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration() .master("mymaster")
                .sentinel("192.168.1.72", 26379) .sentinel("192.168.1.72", 26380);
        return new JedisConnectionFactory(sentinelConfig);
    }




}
