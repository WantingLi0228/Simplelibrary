package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器 - Interceptor
 *
 * TODO: 实现以下拦截逻辑
 *
 * 【拦截器】预处理/后处理HTTP请求
 *
 * 1. 登录校验拦截器
 *    - 检查请求头中是否有token
 *    - 验证token有效性
 *    - 无效则返回401未授权
 *
 * 2. 请求日志拦截器
 *    - 记录请求来源IP
 *    - 记录请求URL和参数
 *    - 记录请求时间
 *
 * 3. 限流拦截器(可选)
 *    - 基于IP的请求频率限制
 *
 * 【拦截器方法】
 * - preHandle(): 请求预处理，返回true才会继续执行
 * - postHandle(): 请求处理后、视图渲染前执行
 * - afterCompletion(): 整个请求完成后执行
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    // TODO: preHandle - 请求预处理
    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    //     String token = request.getHeader("Authorization");
    //     // 验证token...
    //     return true;
    // }

    // TODO: postHandle - 请求处理后
    // @Override
    // public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    //     // 可添加公共数据到视图
    // }

    // TODO: afterCompletion - 请求完成
    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    //     // 清理资源、记录日志等
    // }
}