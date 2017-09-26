package com.pl.microservicesimpleprovideruser.WEB;

import com.pl.microservicesimpleprovideruser.DAO.UserRepository;
import com.pl.microservicesimpleprovideruser.DTO.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 庞亮 on 2017/9/18.
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails){
//            UserDetails user = (UserDetails)principal;
//            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
//            for (GrantedAuthority c:
//                 collection) {
//                this.LOGGER.info("当前用户是{}，角色是{}",user.getUsername(),c.getAuthority());
//            }
//        }else{
//
//        }
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }
}
