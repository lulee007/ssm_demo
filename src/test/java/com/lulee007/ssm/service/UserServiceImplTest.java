package com.lulee007.ssm.service;

import com.lulee007.ssm.JUnit4ClassRunner;
import com.lulee007.ssm.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luxiaohui on 16/1/26.
 */
@RunWith( JUnit4ClassRunner.class ) //指定单元测试运行类
@ContextConfiguration( locations = { "classpath*:config/spring/applicationContext-*.xml" } ) //指定Spring配置文件的位置
//很多情况下单元测试离不开事务，下面的注解指明使用的事务管理器
//如果defaultRollback为true，测试运行结束后，默认回滚事务，不影响数据库
@TransactionConfiguration( transactionManager = "dataSourceTransactionManager", defaultRollback = true )
@Transactional //指定默认所有测试方法的事务特性
public class UserServiceImplTest {

    //该字段本身由Spring自动注入
    @Inject
    UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindUser() throws Exception {
        //事先已经在数据库插入了一条数据
        List<User> allUsers=userService.findUser();
        assertEquals(allUsers.size(),1);
    }

    @Test
    public void testSaveUser() throws Exception {
        //测试 插入一条新数据
        User user=new User();
        user.setUsername("lulee007");
        Boolean result=userService.saveUser(user);
        assertEquals(result,Boolean.TRUE);

    }
}