package com.geekgame.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * session配置类
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 24*60*60)
public class SpringHttpSessionConfig {
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID");
        serializer.setDomainName("final.lppnb.top");
        serializer.setCookiePath("/");
        serializer.setUseHttpOnlyCookie(false);
        serializer.setSameSite(null);
        // 最大生命周期的单位是秒
        serializer.setCookieMaxAge(24 * 60 * 60);
        return serializer;
    }

}
