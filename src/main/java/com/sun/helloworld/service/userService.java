package com.sun.helloworld.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.helloworld.abstracts.BaseService;
import com.sun.helloworld.entity.temp_user;
import com.sun.helloworld.mapper.user_Mapper;

@Service
public class userService extends BaseService {
	@Autowired
    private user_Mapper mapper;

    public temp_user getUser(int id) {
        QueryWrapper<temp_user> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(temp_user::getId, id);

        return mapper.selectOne(queryWrapper);
    }
    
    public int createUser(temp_user user) {
        
        return mapper.insert(user);
    }
    
    public int delete(int id) {
		return mapper.deleteById(id);
	}
    
    public int update(int id,String name) {
    	 QueryWrapper<temp_user> updateWrapper = new QueryWrapper<>();
    	 updateWrapper.lambda().eq(temp_user::getId, id);
    	 temp_user user = new temp_user();
    	 user.setId(id);
    	 user.setDate(new Date());
    	 user.setName(name);
		return mapper.update(user, updateWrapper);
	}
}
