package com.pl.microservicesimpleconsumermovie.CONFIG;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 庞亮 on 2017/9/19.
 */
@Configuration
public class FeignConfiguration {
    //注意下面开启使用FEIGN注解后就不能再使用springmvc注解了
    //同理开启了SPRINGMVC的不能用feign的
//    @Bean
//    public Contract feignContract(){
//        return new feign.Contract.Default();
//    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
