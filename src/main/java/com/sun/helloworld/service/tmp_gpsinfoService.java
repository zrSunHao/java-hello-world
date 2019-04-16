package com.sun.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.helloworld.abstracts.BaseService;
import com.sun.helloworld.entity.tmp_gpsinfo;
import com.sun.helloworld.mapper.tmp_gpsinfoMapper;

@Service
public class tmp_gpsinfoService extends BaseService {

    @Autowired
    private tmp_gpsinfoMapper tmpgpsinfoMapper;

    public tmp_gpsinfo getGpsinfo(String number) {
        QueryWrapper<tmp_gpsinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(tmp_gpsinfo::getApplicationnumber, number);

        return tmpgpsinfoMapper.selectOne(queryWrapper);
    }
    
    
}
