package com.baidu.uuap.controller;

import com.baidu.uuap.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisDao redisDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void transfer() {
        redisDao.setKey("kk","123");
        String kk = redisDao.getValue("kk");
        System.out.println("kk="+kk);
    }
}