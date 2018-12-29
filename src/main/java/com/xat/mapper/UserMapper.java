package com.xat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.xat.entity.User;

@Mapper
public interface UserMapper {
 
    User Sel(int id);
 
    User login(String userName,String passWord);
 
    int register(User user);

}