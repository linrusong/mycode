package com.wasu.ptyw.crm.controller;

import com.wasu.ptyw.common.dataobject.result.QueryResult;
import com.wasu.ptyw.common.dataobject.result.Result;
import com.wasu.ptyw.crm.ao.MenuAO;
import com.wasu.ptyw.crm.dataobject.MenuDO;
import com.wasu.ptyw.crm.dataobject.form.MenuForm;
import com.wasu.ptyw.crm.dataobject.form.MenuQuery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuAO menuAO;

    @RequestMapping(value = "/list.htm")
    public String menuCRUD() {
        return "/menu/menuList";
    }

    /**
     * 通过查询Form里的查询字段，查询菜单列表
     * @param menuQuery
     * @param request
     * @return jsonData
     */
    @RequestMapping(value = "/list.json")
    public @ResponseBody Object list(MenuQuery menuQuery,HttpServletRequest request) {

        menuQuery.setCurrentPageString(request.getParameter("page"));
        menuQuery.setPageSizeString(request.getParameter("rows"));
        QueryResult<List<MenuForm>> menuList = menuAO.queryMenuList(menuQuery);
        if (menuList.isSuccess()) {
            Map<String, Object> jsonResult = new HashMap<String, Object>();
            jsonResult.put("rows", menuList.getModel());
            jsonResult.put("total", menuList.getModel().size());

            return jsonResult;
        } else {
            //跳转错误页面、输出错误信息
            return "";
        }
    }

    /**
     * 异步保存增加菜单。
     * @param menuForm
     */
    @RequestMapping(value = "/save.do")
    public @ResponseBody void save(MenuForm menuForm) {
        try {
//        flexJson的反序列化,可能会报反序列化时类型转换错误。
//            List<MenuChangeForm> list = new JSONDeserializer<List<MenuChangeForm>>().use("values", MenuChangeForm.class).deserialize(data);

//          jackson的反序列化
//        List<MenuChangeForm> list= (List<MenuChangeForm>)new ObjectMapper().readValues(data,new TypeReference<List<MenuChangeForm>>(){});

            menuAO.saveMenu(menuForm);
        } catch (Exception e) {
            //错误处理
        }
    }

    /**
     * 异步保存更新菜单数据。
     * @param menuForm
     */
    @RequestMapping(value = "/update.do")
    public @ResponseBody void update(MenuForm menuForm) {
        try {
            menuAO.updateMenu(menuForm);
        } catch (Exception e) {
            //错误处理
        }
    }

    /**
     * 异步保存删除菜单操作。
     * @param id
     */
    @RequestMapping(value = "/delete.do")
    public @ResponseBody void delete(Long id) {
        try {
            menuAO.deleteMenu(id);
        } catch (Exception e) {
            //错误处理
        }
    }

}
