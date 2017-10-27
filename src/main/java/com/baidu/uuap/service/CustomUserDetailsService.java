package com.baidu.uuap.service;

import com.baidu.uuap.dao.SysUserRepository;
import com.baidu.uuap.pojo.SysRole;
import com.baidu.uuap.pojo.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired //数据库服务类
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        for (SysRole role : user.getRoles()) {
            logger.info("role:::" + role.getName());
            // 此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
            authorities.add(new SimpleGrantedAuthority(role.getName()));//添加用户权限
        }

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}