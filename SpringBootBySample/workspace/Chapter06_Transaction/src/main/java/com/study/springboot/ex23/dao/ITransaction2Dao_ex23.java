package com.study.springboot.ex23.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction2Dao_ex23 {
    public void pay(String consumerId, int amount);
}
