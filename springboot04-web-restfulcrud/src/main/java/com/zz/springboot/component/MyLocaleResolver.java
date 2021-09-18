package com.zz.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求参数
        String language = request.getParameter("language");

        // 设置国际化 操作系统默认的语言
        // Locale locale = request.getLocale();

        // 设置国际化 从请求头获取language
        // Accept-Language:zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
        String header = request.getHeader("Accept-Language");
        System.out.println(header);

        String[] strings = header.split(",");

        Locale locale = new Locale(strings[0]);

        // 如果url存在language，则设置为locale的属性值
        if (StringUtils.hasText(language)) {
            strings = language.split("_");
            locale = new Locale(strings[0], strings[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
