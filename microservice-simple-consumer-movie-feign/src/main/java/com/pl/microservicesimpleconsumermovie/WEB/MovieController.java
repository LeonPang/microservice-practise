package com.pl.microservicesimpleconsumermovie.WEB;

import com.google.common.collect.Maps;
import com.pl.microservicesimpleconsumermovie.DTO.User;
import com.pl.microservicesimpleconsumermovie.SERVICE.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by 庞亮 on 2017/9/18.
 */
@RestController
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private UserFeignClient userFeignClient;

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;


    //此处加@HystrixCommand是针对这个controller里的方法的，实际上要针对的是调用rest的地方，也就是给feign加hystrix
//    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
//        return this.restTemplate.getForObject(this.userServiceUrl + id, User.class );
        //用feign,把获取服务地址交给RIBBON
        return this.userFeignClient.findById(id);
    }
//    实际是对于feign的回退，所以不用在这里而是在feign接口中
//    public User findByIdFallback(Long id){
//        User user = new User();
//        user.setAge(1111111);
//        user.setName("XXXXXXXXXXXXXXXX");
//        return user;
//    }
    @GetMapping("/user/value")
    public User get2(){
//        return this.restTemplate.getForObject(this.userServiceUrl + id, User.class );
        //用feign,把获取服务地址交给RIBBON
        Map<String,Object> map = Maps.newHashMap();
        map.put("a",1);
        map.put("b","b");
        return this.userFeignClient.get2(map);
    }


    /**
     * 测试URL：http://localhost:8010/user/get1?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
//    @GetMapping("/user/get1")
//    public User get1(User user) {
//        return this.userFeignClient.get1(user.getId(), user.getUsername());
//    }

    /**
     * 测试URL：http://localhost:8010/user/get2?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get2")
    public User get2(User user) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        return this.userFeignClient.get2(map);
    }
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        //测试这里是不是application.name
        return this.discoveryClient.getInstances("microservice-provider-user");
    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        //测试这里是不是application.name
//        return this.discoveryClient.getInstances("microservice-provider-user");
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
