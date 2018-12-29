package com.xat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xat.entity.User;
import com.xat.mapper.UserMapper;

@Service
public class UserService {
	
    @Autowired
    private UserMapper userMapper;
    
    public User Sel(int id){
        return userMapper.Sel(id);
    }
 
    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }
 
    public int register(User user) {
        return userMapper.register(user);
    }
}
