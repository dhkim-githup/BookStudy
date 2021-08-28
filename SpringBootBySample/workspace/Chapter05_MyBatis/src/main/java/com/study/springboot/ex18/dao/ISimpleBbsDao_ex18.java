package com.study.springboot.ex18.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.ex18.dto.SimpleBbsDto_ex18;

@Mapper
public interface ISimpleBbsDao_ex18 {

    public List<SimpleBbsDto_ex18> listDao();
    public SimpleBbsDto_ex18 viewDao(String id);
    //public int writeDao(String writer, String title, String content);
    public int writeDao(Map<String, String> map);
    public int deleteDao(@Param("_id") String id);
    public int articleCount();
}
