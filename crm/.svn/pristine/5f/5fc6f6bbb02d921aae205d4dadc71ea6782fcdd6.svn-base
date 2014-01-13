package com.wasu.ptyw.crm.controller;

import com.wasu.ptyw.common.dataobject.result.QueryResult;
import com.wasu.ptyw.common.dataobject.result.Result;
import com.wasu.ptyw.crm.ao.UserAO;
import com.wasu.ptyw.crm.dataobject.UserDO;
import com.wasu.ptyw.crm.dataobject.form.UserLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserAO userAO;

    @RequestMapping(value = "/login.do")
    public @ResponseBody QueryResult<UserDO> login(UserLoginForm userLoginForm,HttpServletResponse response) {
        return userAO.userLogin(userLoginForm,response);
    }

    @RequestMapping(value = "/register.do")
    public @ResponseBody Result register(UserDO userDO,HttpServletRequest request){
//        method=get情况下，启用下面转码
//        try {
//            userDO.setUsername(new String(userDO.getUsername().getBytes("iso8859-1"),"UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
        return userAO.userRegister(userDO);
    }

}


