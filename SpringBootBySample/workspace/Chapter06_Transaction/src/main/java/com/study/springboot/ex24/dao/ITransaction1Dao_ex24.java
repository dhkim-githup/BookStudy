package com.study.springboot.ex24.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction1Dao_ex24 {
    public void pay(String consumerId, int amount);
}
