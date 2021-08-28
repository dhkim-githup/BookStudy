package com.study.springboot.ex24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.ex24.dao.ITransaction3Dao_ex24;

@Service
public class LogWriteService {

    @Autowired
    ITransaction3Dao_ex24 transaction3;

    public int write(String consumerId, int amount) {

        try {
            transaction3.pay(consumerId, amount);
            return 1;
        } catch(Exception e) {
            return 0;
        }
    }

}
