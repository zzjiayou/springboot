package com.zz.springboot.config;

import com.zz.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 保持springboot mvc的自动配置，并且扩展
 * springboot 1.5 继承WebMvcConfigurerdApterr类型
 * springboot 2.4.5 实现WebMvcConfigurer
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 相当于springmvc.xml的view-controller标签
        registry.addViewController("/zz").setViewName("success");

        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        // registry.addInterceptor(new LoginHandlerInteceptor()).addPathPatterns("/**")
        //         .excludePathPatterns("/", "/index.html", "/user/login", "/asserts/**", "/webjars/**");
    }

    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
