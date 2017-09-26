package com.pl.microservicesimpleconsumermovie.SERVICE;

import com.pl.microservicesimpleconsumermovie.CONFIG.FeignConfiguration;
import com.pl.microservicesimpleconsumermovie.DTO.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by 庞亮 on 2017/9/19.
 */
//@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class,fallback = UserFeignClient.FeignClientFallback.class)
//测试使用FallbaclFactory,切记这次是factory上面只是fallback，这里也会针对接口中的每个方法做。区别是获取到了异常信息，但是有时候会为null，是BUG所以要加上判断
@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class,fallbackFactory = FeignClientFallbaclFactory.class)
public interface UserFeignClient {
//   这是在接口中 无法使用此注解！ @HystrixCommand(fallbackMethod = "")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    //测试使用配置类后的FEIGN自带注解
//    @RequestLine("GET /{id}")
//    public User findById(@Param("id") Long id);

//    @RequestMapping(value = "/get",method = RequestMethod.GET)
//    public User get2(@RequestParam Map<String,Object> map);

    //consumer用map provider用get map接只有在使用了springmvc注解后成功了
//    @RequestLine("GET /get")
//    public User get2(@Param("map") Map<String,Object> map);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get2(@RequestParam Map<String, Object> map);

    //此类中对应feign的所有接口实现默认值
    @Component
    class FeignClientFallback implements UserFeignClient{

        @Override
        public User findById(@PathVariable("id") Long id) {
            User user = new User();
            user.setAge(222222222);
            user.setName("YYYYYYYYYYYYYYYYYYYYYYYY");
            return user;
        }

        @Override
        public User get1(@RequestParam("id") Long id, @RequestParam("username") String username) {
            return null;
        }

        @Override
        public User get2(@RequestParam Map<String, Object> map) {
            return null;
        }
    }


}

@Component
class FeignClientFallbaclFactory implements FallbackFactory<UserFeignClient>{
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbaclFactory.class);
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(@PathVariable("id") Long id) {
                //直接打Throwable是不行的 这里相当于转换了
                FeignClientFallbaclFactory.LOGGER.info(":",throwable);
                User user = new User();
                user.setAge(33333);
                user.setName("qqqqqqqqqqqqqq");
                return user;
            }

            @Override
            public User get1(@RequestParam("id") Long id, @RequestParam("username") String username) {
                return null;
            }

            @Override
            public User get2(@RequestParam Map<String, Object> map) {
                return null;
            }
        };
    }
}
