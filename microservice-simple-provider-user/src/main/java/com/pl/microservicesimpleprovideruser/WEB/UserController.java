package com.pl.microservicesimpleprovideruser.WEB;

import com.pl.microservicesimpleprovideruser.DAO.UserRepository;
import com.pl.microservicesimpleprovideruser.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 庞亮 on 2017/9/18.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/get")
    public User get2(@RequestParam Map<String,Object> map){
        System.out.println(map);
        User findOne = this.userRepository.findOne(3L);
        return findOne;
    }
}
