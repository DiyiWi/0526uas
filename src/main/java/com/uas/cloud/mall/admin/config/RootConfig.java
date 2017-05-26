package com.uas.cloud.mall.admin.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Bean配置
 *
 * @author umall
 * @create 2017/2/15
 */
@Configuration
public class RootConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 文件上传
     * StandardServletMultipartResolver与Spring Boot自动配置的StandardServletMultipartResolver 向冲突，所以建议使用SpringBoot配置好的MultipartResolver，用到CommonsMultipartFile时做一下适配
     * @return
     */
    //@Bean
    //public MultipartResolver multipartResolver() {
    //    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    //    multipartResolver.setDefaultEncoding("UTF-8");
    //    System.out.println("--------yangck--------multipartResolver=" + multipartResolver + "," + "当前类=RootConfig.multipartResolver()");
    //    return multipartResolver;
    //}



}
