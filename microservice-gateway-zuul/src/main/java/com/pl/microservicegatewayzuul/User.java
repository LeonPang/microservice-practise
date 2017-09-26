package com.pl.microservicegatewayzuul;

import java.math.BigDecimal;

/**
 * Created by 庞亮 on 2017/9/21.
 */
public class User {
    private Long id;
    private String username;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
