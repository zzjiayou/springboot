package com.zz.springboot.config;

import com.zz.springboot.filter.MyFilter;
import com.zz.springboot.listener.MyListener;
import com.zz.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {
    //自定义servlet的配置
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }

    //给容器添加servlet
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }

    //添加filter
    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        FilterRegistrationBean<MyFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new MyFilter());
        filter.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filter;
    }

    //添加listener
    @Bean
    public ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
}
