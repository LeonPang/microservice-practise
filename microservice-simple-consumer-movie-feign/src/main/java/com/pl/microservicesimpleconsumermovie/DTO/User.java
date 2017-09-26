package com.pl.microservicesimpleconsumermovie.DTO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by 庞亮 on 2017/9/18.
 */
public class User
{
    private long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
