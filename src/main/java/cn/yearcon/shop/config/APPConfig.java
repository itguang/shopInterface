package cn.yearcon.shop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APPConfig {

    /**
     * jackson 配置
     * @return ObjectMapper对象
     */
    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }


}
