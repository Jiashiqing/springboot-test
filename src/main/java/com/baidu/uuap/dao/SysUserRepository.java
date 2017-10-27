package com.baidu.uuap.dao;

import com.baidu.uuap.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiashiqing on 17/10/21.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);


}
