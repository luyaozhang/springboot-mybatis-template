package com.siku.management.mapper;

import com.siku.management.model.LoginUser;
import org.springframework.stereotype.Service;

@Service
public interface LoginUserMapper {
    int deleteByPrimaryKey(String username);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
}