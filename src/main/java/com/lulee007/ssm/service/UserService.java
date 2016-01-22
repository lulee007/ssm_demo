package com.lulee007.ssm.service;

import com.lulee007.ssm.pojo.User;

import java.util.List;

/**
 * Created by lulee007 on 16/1/19.
 */
public interface UserService {
    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    List<User> findUser()throws Exception;

    Boolean saveUser(User user) throws  Exception;
}
