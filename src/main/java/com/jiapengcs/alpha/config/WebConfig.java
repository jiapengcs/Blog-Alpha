package com.jiapengcs.alpha.config;

import com.jiapengcs.alpha.interceptor.AdminInterceptor;
import com.jiapengcs.alpha.interceptor.CommentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Autowired
    private CommentInterceptor commentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login");
        registry.addInterceptor(commentInterceptor).addPathPatterns("/comment/save");
    }
}
