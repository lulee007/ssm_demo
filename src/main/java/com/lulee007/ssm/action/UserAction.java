package com.lulee007.ssm.action;

import com.lulee007.ssm.pojo.User;
import com.lulee007.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * Created by lulee007 on 16/1/21.
 */
//将这个UserAction 注解为Controller
@Controller
public class UserAction {

    //自动注解UserService
    @Autowired
    private UserService userService;

    private String title;
    private List<User> users;

    //action 默认执行的入口
    public String execute(){
        try {
            //取出所有user
            users=userService.findUser();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置标题
        title="My User Page"+new Date();
        return "success";
    }

    /***
     * 以下是 getter setter 在jsp里要调用我们的 title 和 users 就必须写setter getter方法,不然
     * 没法取到或设置其值.
     * ****/
    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
