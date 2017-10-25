package cn.yearcon.shop.config;

import cn.yearcon.shop.entity.ShopConfig;
import cn.yearcon.shop.fliter.CheckOpenidFilter;
import cn.yearcon.shop.service.ShopConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${weixin.domain}")
    private String domain;


    private String appid;

    @Autowired
    private ShopConfigService shopConfigService;

    @Bean
    public FilterRegistrationBean testFilterRegistrationBean() {

        ShopConfig shopConfig = shopConfigService.getById("1");

        appid = shopConfig.getAppid();

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CheckOpenidFilter());
        registrationBean.addUrlPatterns("/shop/*");
        registrationBean.addInitParameter("domain", domain);
        registrationBean.addInitParameter("appid",appid);
        registrationBean.setName("CheckOpenidFilter");
        registrationBean.setOrder(1);


        return registrationBean;
    }
}
