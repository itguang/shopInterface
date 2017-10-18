package cn.yearcon.shop.config;

import cn.yearcon.shop.fliter.CheckOpenidFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 过滤器配置类
 *
 * @author itguang
 * @create 2017-10-18 11:20
 **/
@Configuration
public class CheckOpenidFilterConfig {

    @Bean
    public FilterRegistrationBean testFilterRegistrationBean() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CheckOpenidFilter());
        registrationBean.addUrlPatterns("/shop/*");
        registrationBean.addInitParameter("paramName", "value");
        registrationBean.setName("CheckOpenidFilter");
        registrationBean.setOrder(1);


        return registrationBean;
    }
}
