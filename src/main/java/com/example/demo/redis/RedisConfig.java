package com.example.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis配置类
 *
 * TODO: 配置RedisTemplate
 *
 * 【Redis】配置序列化器
 *
 * - Key序列化: StringRedisSerializer
 * - Value序列化: Jackson2JsonRedisSerializer (JSON格式存储对象)
 *
 * 【分布式锁】可定义锁的Bean
 *
 * Redis应用场景:
 * 1. 图书缓存: 查询图书时先查Redis，缓存命中则返回，否则查数据库并写入Redis
 * 2. 借阅限量: 用户借书时使用Redis原子操作扣减库存，防止超卖
 * 3. 分布式锁: 基于SETNX + 过期时间实现，用于确保同一用户不能同时借阅同一本书
 */
@Configuration
public class RedisConfig {

    // TODO: 配置RedisTemplate
    // @Bean
    // public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    //     RedisTemplate<String, Object> template = new RedisTemplate<>();
    //     template.setConnectionFactory(factory);
    //     // 设置序列化器...
    //     return template;
    // }

    // TODO: 定义分布式锁
    // public String tryLock(String key, String value, long expireTime) {
    //     // SETNX + 过期时间
    // }

    // TODO: 释放分布式锁
    // public boolean releaseLock(String key, String value) {
    //     // Lua脚本确保原子性
    // }
}