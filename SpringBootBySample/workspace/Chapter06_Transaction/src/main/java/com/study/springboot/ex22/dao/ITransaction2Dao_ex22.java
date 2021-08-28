package com.study.springboot.ex22.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction2Dao_ex22 {
    public void pay(String consumerId, int amount);
}
