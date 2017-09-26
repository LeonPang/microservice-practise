package com.pl.microservicesimpleprovideruser.DAO;

import com.pl.microservicesimpleprovideruser.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 庞亮 on 2017/9/18.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
