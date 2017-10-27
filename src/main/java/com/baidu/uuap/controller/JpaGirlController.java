package com.baidu.uuap.controller;

import com.baidu.uuap.dao.GirlSpecs;
import com.baidu.uuap.dao.JpaGirlDao;
import com.baidu.uuap.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@RestController
@RequestMapping("/girl")
public class JpaGirlController {

    @Autowired
    JpaGirlDao jpaGirlDao;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Girl> findAll() {
        return jpaGirlDao.findAll(GirlSpecs.girlSpecification());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Girl> findByCupSize() {
        return jpaGirlDao.findByCupSize("B",new Sort(Sort.Direction.ASC,"age"));
    }

    @RequestMapping(value = "/listtop1", method = RequestMethod.GET)
    public List<Girl> findTop1ByCupSize() {
        return jpaGirlDao.findTop1ByCupSize("B");
    }

    @RequestMapping(value = "/listquery", method = RequestMethod.GET)
    public List<Girl> findByName() {
        return jpaGirlDao.findByAge(11);
    }

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public int setAge() {
        return jpaGirlDao.setAge(11);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public List<Girl> sort() {
        return jpaGirlDao.findByCupSize("B", new Sort(Sort.Direction.ASC, "age"));
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Girl> page() {
        return jpaGirlDao.findByCupSizeAndAge("B", new PageRequest(0, 2));
    }
}