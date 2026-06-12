package com.example.demo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 业务切面类 - AOP
 *
 * TODO: 实现以下AOP切面逻辑
 *
 * 【AOP】面向切面编程，拦截特定方法调用
 *
 * 1. 日志切面
 *    - 记录每次借书/还书的操作日志
 *    - @Before: 方法执行前记录
 *    - @After: 方法执行后记录
 *    - @AfterReturning: 方法返回后记录
 *
 * 2. 性能监控切面
 *    - 统计方法执行耗时
 *    - @Around: 包裹方法，计算执行时间
 *
 * 3. 逾期提醒切面
 *    - 当checkOverdue()检测到逾期时，发送通知
 *    - 结合MQ发送逾期提醒消息
 *
 * 【Pointcut表达式示例】
 * - execution(* com.example.demo.service.BorrowServiceImpl.borrowBook(..))
 * - execution(* com.example.demo.service..*(..))
 */
@Aspect
@Component
public class BorrowAspect {

    // TODO: 定义Pointcut
    // @Pointcut("execution(* com.example.demo.service.BorrowService.*(..))")

    // TODO: @Before 记录借书操作开始
    // @Before("pointcut()")
    // public void beforeBorrow() { ... }

    // TODO: @AfterReturning 记录借书成功
    // @AfterReturning(pointcut = "pointcut()", returning = "result")
    // public void afterBorrow(Object result) { ... }

    // TODO: @Around 统计方法执行时间
    // @Around("pointcut()")
    // public Object measureTime(ProceedingJoinPoint joinPoint) { ... }
}