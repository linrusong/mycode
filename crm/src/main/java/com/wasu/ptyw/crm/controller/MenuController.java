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
 * @Date: 14-1-9 ����11:05
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
     * ͨ����ѯForm��Ĳ�ѯ�ֶΣ���ѯ�˵��б�
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
            //��ת����ҳ�桢���������Ϣ
            return "";
        }
    }

    /**
     * �첽�������Ӳ˵���
     * @param menuForm
     */
    @RequestMapping(value = "/save.do")
    public @ResponseBody void save(MenuForm menuForm) {
        try {
//        flexJson�ķ����л�,���ܻᱨ�����л�ʱ����ת������
//            List<MenuChangeForm> list = new JSONDeserializer<List<MenuChangeForm>>().use("values", MenuChangeForm.class).deserialize(data);

//          jackson�ķ����л�
//        List<MenuChangeForm> list= (List<MenuChangeForm>)new ObjectMapper().readValues(data,new TypeReference<List<MenuChangeForm>>(){});

            menuAO.saveMenu(menuForm);
        } catch (Exception e) {
            //������
        }
    }

    /**
     * �첽������²˵����ݡ�
     * @param menuForm
     */
    @RequestMapping(value = "/update.do")
    public @ResponseBody void update(MenuForm menuForm) {
        try {
            menuAO.updateMenu(menuForm);
        } catch (Exception e) {
            //������
        }
    }

    /**
     * �첽����ɾ���˵�������
     * @param id
     */
    @RequestMapping(value = "/delete.do")
    public @ResponseBody void delete(Long id) {
        try {
            menuAO.deleteMenu(id);
        } catch (Exception e) {
            //������
        }
    }

}