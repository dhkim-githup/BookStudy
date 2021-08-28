package com.study.springboot.ex20.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.study.springboot.ex20.dto.SimpleBbsDto_ex20;


public interface ISimpleBbsService_ex20 {

    public List<SimpleBbsDto_ex20> list();
    public SimpleBbsDto_ex20 view(String id);
    public int write(Map<String, String> map);
    public int delete(@Param("_id")String id);
    public int count();
}
