package com.wasu.ptyw.crm.controller;

import com.wasu.ptyw.common.dataobject.result.QueryResult;
import com.wasu.ptyw.crm.ao.MenuAO;
import com.wasu.ptyw.crm.dataobject.MenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private MenuAO menuAO;

    @RequestMapping(value = "main.htm")
    public String index() {
        return "/main/main";
    }

    @RequestMapping(value = "login.htm")
    public String login(HttpServletRequest request) {
        return "/main/login";
    }

    /**
     * 异步返回菜单树结构。
     *
     */
    @RequestMapping(value = "/menuTree.json")
    public @ResponseBody Object getMenuTree(){
        QueryResult<List<MenuDO>> result = menuAO.queryMenuTree();
        if(result.isSuccess()){

            return result.getModel();

        }else{
            //跳转错误页面、输出错误信息
            return "";
        }
    }

}
