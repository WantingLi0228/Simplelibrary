package com.example.demo.config;

import com.example.demo.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC配置类 - 拦截器注册
 *
 * 【MVC配置】注册拦截器，指定拦截路径
 *
 * TODO: 配置拦截器规则
 *
 * 配置项:
 * - addInterceptor(): 添加拦截器实例
 * - addPathPatterns(): 指定拦截的URL路径
 * - excludePathPatterns(): 排除不需要拦截的URL
 *
 * 示例:
 * - /students/** - 拦截所有学生相关请求
 * - /books/** - 拦截所有图书相关请求
 * - /borrow/** - 拦截所有借阅相关请求
 * - /login/** - 排除登录接口
 * - /error/** - 排除错误页面
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO: 注册拦截器
        // registry.addInterceptor(authInterceptor)
        //         .addPathPatterns("/**")
        //         .excludePathPatterns("/login/**", "/error/**");
    }
}