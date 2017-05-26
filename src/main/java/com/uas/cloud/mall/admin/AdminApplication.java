package com.uas.cloud.mall.admin;

import com.uas.cloud.mall.admin.config.RootConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author yangck
 * @create 2017-02-16 16:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Import(RootConfig.class)
public class AdminApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminApplication.class).web(true).run(args);
    }
}
