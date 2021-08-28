package com.study.springboot.ex20.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.ex20.dao.ISimpleBbsDao_ex20;
import com.study.springboot.ex20.dto.SimpleBbsDto_ex20;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SimpleBbsService_ex20 implements ISimpleBbsService_ex20 {

    @Autowired
    ISimpleBbsDao_ex20 dao;

    @Override
    public List<SimpleBbsDto_ex20> list() {
    	log.info("Service list");
        return dao.listDao();
    }

    @Override
    public SimpleBbsDto_ex20 view(String id) {
     	log.info("Service view");
        return dao.viewDao(id);
    }

    @Override
    public int write(Map<String, String> map) {
    	log.info("Service write");
        int nResult = dao.writeDao(map);
        return nResult;
    }

    @Override
    public int delete(String id) {
       	log.info("Service delete");	
        int nResult = dao.deleteDao(id);
        return nResult;
    }

    @Override
    public int count() {
      	log.info("Service count");		
        int nTotalCount = dao.articleCount();
        return nTotalCount;
    }

}
