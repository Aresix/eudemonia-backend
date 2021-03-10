package com.aresix.eudemoniabackend;

import com.aresix.eudemoniabackend.interceptors.PortalLoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
public class SpringBootConfig implements WebMvcConfigurer {

    @Autowired
    PortalLoginCheckInterceptor portalLoginCheckInterceptor;

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeUrl=new ArrayList<>();
        excludeUrl.add("/back/user/login.do");
        excludeUrl.add("/back/user/register.do");
        excludeUrl.add("/back/user/logout.do");

        registry.addInterceptor(portalLoginCheckInterceptor)
                .addPathPatterns("/back/user/**")
                .addPathPatterns("/upload")
                .excludePathPatterns(excludeUrl);
    }
}
