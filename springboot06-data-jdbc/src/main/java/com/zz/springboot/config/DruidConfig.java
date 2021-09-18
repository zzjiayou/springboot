package com.zz.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//添加 druid的相关组件 servlet filter 作用是监控
@Configuration
public class DruidConfig {

    //从配置文件中获取属性值
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //配置Druid的监控
    //配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        map.put("allow", "");//默认允许所有访问
        map.put("deny", "192.168.206.128");
        bean.setInitParameters(map);
        return bean;
    }

    //配置一个监控的filter
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String, String> map = new HashMap<>();
        map.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
