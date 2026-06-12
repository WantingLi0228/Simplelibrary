package com.example.demo.redis;

/**
 * Redis锁工具类
 *
 * TODO: 实现分布式锁
 *
 * 【分布式锁】基于Redis实现互斥访问
 *
 * 实现思路:
 * 1. tryLock(): 使用SETNX尝试获取锁，设置过期时间防止死锁
 * 2. releaseLock(): 使用Lua脚本释放锁，确保只能释放自己持有的锁
 *
 * 应用场景:
 * - 同一用户不能同时借阅同一本书(并发控制)
 * - 同一图书库存的并发扣减
 *
 * 【Redis数据结构】
 * - String: 存储锁的状态
 * - Lua脚本: 保证释放锁的原子性
 *
 * 【超时时间】建议设置合理超时时间，避免死锁，也避免业务执行过长被自动释放
 */
public class RedisLockUtil {

    // TODO: 尝试获取锁
    // public boolean tryLock(String lockKey, String lockValue, long expireTime) {
    //     // Redis: SET lockKey lockValue NX PX expireTime
    // }

    // TODO: 释放锁(Lua脚本保证原子性)
    // public boolean releaseLock(String lockKey, String lockValue) {
    //     // Redis: EVAL "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end"
    // }

    // TODO: 借书锁定(防止同一用户短时间内重复借书)
    // public boolean lockBorrow(Long userId, Long bookId) {
    //     String lockKey = "borrow:user:" + userId + ":book:" + bookId;
    //     return tryLock(lockKey, "1", 30);
    // }
}