package com.lulee007.ssm.service;

import com.lulee007.ssm.mapper.UserMapper;
import com.lulee007.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lulee007 on 16/1/19.
 */
@Service
public class UserServiceImpl implements UserService {
    //User接口
    @Autowired
    private UserMapper userMapper;

    public List<User> findUser() throws Exception {
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        List<User> users = userMapper.selectByExample(null);

        return users;
    }

    public Boolean saveUser(User user) throws Exception {
        return userMapper.insertSelective(user)==1;
    }
}
