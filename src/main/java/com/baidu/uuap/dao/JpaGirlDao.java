package com.baidu.uuap.dao;

import com.baidu.uuap.pojo.Girl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiashiqing on 17/10/21.
 */
//@RepositoryRestResource(path = "rest") //定制节点路径
public interface JpaGirlDao extends JpaRepository<Girl, Integer>, JpaSpecificationExecutor<Girl> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    List<Girl> findByName(@Param("name") String name);

    List<Girl> findTop1ByCupSize(String cupSize);

    @Query("select g from Girl g where g.age=?1")
    List<Girl> findByAge(int age);

    /**
     * 更新
     *
     * @param age
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Girl g set g.age=?1 where g.age=10")
    int setAge(int age);

    /**
     * 排序
     *
     * @param cupSize
     * @param sort
     * @return
     */
    List<Girl> findByCupSize(String cupSize, Sort sort);

    /**
     * 分页
     *
     * @param cupSize
     * @param pageable
     * @return
     */
    Page<Girl> findByCupSizeAndAge(String cupSize, Pageable pageable);

}
