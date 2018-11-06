package com.rest.controller;


import com.rest.model.UserModel;
import com.rest.quartz.QuartzManager;
import com.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class LoginController {



    @Resource
    private UserService userService;//注入dao

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    /* 用注解@RequestParam绑定请求参数到方法入参
     * 当请求参数username不存在时会有异常发生,可以通过设置属性required=false解决,例如: @RequestParam(value="username", required=false)
     * 若"Content-Type"="application/x-www-form-urlencoded"，post get都可以
     * 若"Content-Type"="application/application/json"，只适用get
     */
    @RequestMapping(value = "/loginByParam", method = RequestMethod.POST)
    public @ResponseBody
    UserModel loginByParam(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "password") String password) {
        System.out.println("userName :  " + userName);
        System.out.println("password :  " + password);

//        UserModel userModel = new UserModel();
//        userModel.setUserName(userName);
//        userModel.setPassword(password);

        UserModel userModel = new UserModel();
        userModel.setUserName("jaty");
        userModel.setPassword("123456");
        userModel.setPhone("15914074227");
        userModel.setSex(1);
        userModel.setHeadUrl("https://www.baidu.com/img/baidu_jgylogo3.gif");
        userModel.setMail("704266215@qq.com");

        QuartzManager.addJob(schedulerFactoryBean);
        System.out.println("============userService===========" +userService);

        userService.addUser(userModel);

        return userModel;
    }


    @RequestMapping(value = "/loginByModel", method = RequestMethod.POST)
    public @ResponseBody
    UserModel loginByModel(UserModel userModel) {
        String userName = userModel.getUserName();
        String password = userModel.getPassword();
        System.out.println("userName :  " + userName);
        System.out.println("password :  " + password);

        UserModel userModelResponse = new UserModel();
        userModelResponse.setUserName(userName);
        userModelResponse.setPassword(password);

        QuartzManager.addJob(schedulerFactoryBean);

        return userModelResponse;
    }

}
