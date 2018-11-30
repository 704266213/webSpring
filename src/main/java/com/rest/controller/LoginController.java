package com.rest.controller;


import com.rest.model.UserModel;
import com.rest.quartz.QuartzManager;
import com.rest.redis.RedisCacheManager;
import com.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class LoginController {


    @Resource
    private UserService userService;//注入dao

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private RedisCacheManager redisCacheManager;

    /* 用注解@RequestParam绑定请求参数到方法入参
     * 当请求参数username不存在时会有异常发生,可以通过设置属性required=false解决,例如: @RequestParam(value="username", required=false)
     * 若"Content-Type"="application/x-www-form-urlencoded"，post get都可以
     * 若"Content-Type"="application/application/json"，只适用get
     */
    @RequestMapping(value = "/loginByParam", method = RequestMethod.POST)
    public @ResponseBody
    UserModel loginByParam(@RequestParam(value = "phone") String phone,
                           @RequestParam(value = "password") String password) {
        System.out.println("phone :  " + phone);
        System.out.println("password :  " + password);
        UserModel userModel = new UserModel();
        userModel.setUserName("jaty");
        userModel.setPassword("123456");
        userModel.setPhone(phone);
        userModel.setSex(1);
        userModel.setHeadUrl("https://www.baidu.com/img/baidu_jgylogo3.gif");
        userModel.setMail("704266215@qq.com");

        //先启动redis服务，测试设置缓存
        //运行 redis-server.exe redis.conf
        //如果需要在远程 redis 服务上执行命令，同样我们使用的也是 redis-cli 命令。
        //    $ redis-cli -h host -p port -a password
        // redis-cli -h 127.0.0.1 -p 6379 -a "root"
        //config set requirepass "123456"
        //auth 123456
        //定时任务
        QuartzManager.addJob(schedulerFactoryBean);

        return userModel;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    UserModel login(UserModel userModel) {
        String userName = userModel.getUserName();
        String password = userModel.getPassword();
        System.out.println("userName :  " + userName);
        System.out.println("password :  " + password);

        UserModel userModelResponse = userService.login(userModel);
        String userId = userModelResponse.getUserId();
        String token = (String) redisCacheManager.get(userId);
        if (token != null) {
            System.out.println("缓存中的token : " + token);
            redisCacheManager.del(userId);
        }
        Random rand = new Random();
        token = String.valueOf(rand.nextInt(10000000) + 10000000);
        userModelResponse.setToken(token);
        System.out.println("新创建的token : " + token);
        redisCacheManager.set(userId, token, 500);
        return userModelResponse;
    }

    /* 用注解@RequestParam绑定请求参数到方法入参
     * 当请求参数username不存在时会有异常发生,可以通过设置属性required=false解决,例如: @RequestParam(value="username", required=false)
     * 若"Content-Type"="application/x-www-form-urlencoded"，post get都可以
     * 若"Content-Type"="application/application/json"，只适用get
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    UserModel register(UserModel userModel) {
        userService.addUser(userModel);
        String userId = userModel.getUserId();
        if (userId != null) {
            Random rand = new Random();
            String token = String.valueOf(rand.nextInt(10000000) + 10000000);
            userModel.setToken(token);
            System.out.println("token : " + token);
            redisCacheManager.set(userId, token, 500);
        }
        return userModel;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public @ResponseBody
    UserModel updateUser(UserModel userModel) {
        userService.updateUserInfo(userModel);
        userModel.setPassword(null);
        return userModel;
    }

}
