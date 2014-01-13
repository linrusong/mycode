package com.wasu.ptyw.crm.ao;

import com.wasu.ptyw.common.dataobject.BaseDO;
import com.wasu.ptyw.common.dataobject.result.QueryResult;
import com.wasu.ptyw.common.dataobject.result.Result;
import com.wasu.ptyw.common.exception.ManagerException;
import com.wasu.ptyw.crm.dataobject.MenuDO;
import com.wasu.ptyw.crm.dataobject.form.MenuForm;
import com.wasu.ptyw.crm.dataobject.form.MenuQuery;
import com.wasu.ptyw.crm.manager.MenuManager;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**.
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */
@Component
public class MenuAO {

    @Autowired
    private MenuManager menuManager;

    /**
     * 获取菜单的datagrid列表
     *
     * @param menuQuery
     * @return QueryResult<List<MenuForm>>
     */
    public QueryResult<List<MenuForm>> queryMenuList(MenuQuery menuQuery) {
        QueryResult<List<MenuForm>> result = new QueryResult<List<MenuForm>>(false);
        try {
            List<MenuDO> menuList = menuManager.queryMenuList(menuQuery);

            List<MenuForm> menuFormList = new ArrayList<MenuForm>();

            if (menuList != null) {

                for (MenuDO menuDO : menuList) {

                    MenuForm tempMenuForm = new MenuForm();
                    BeanUtils.copyProperties(tempMenuForm, menuDO);
                    menuFormList.add(tempMenuForm);

                }

                result.setModel(menuFormList);
                result.setSuccess(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            //相应的错误处理
//            result.setErrorMessage();
//            result.setErrorCode();
        }
        return result;
    }

    /**
     * 查询所有菜单的树结构，并返回。
     *
     * @return QueryResult<List<MenuDO>>
     */
    public QueryResult<List<MenuDO>> queryMenuTree() {
        QueryResult<List<MenuDO>> result = new QueryResult<List<MenuDO>>(false);
        try {
            List<MenuDO> menuList = menuManager.queryAllMenuTree();

            result.setModel(menuList);
            result.setSuccess(true);
        } catch (ManagerException e) {
            //相应的错误处理
//            result.setErrorMessage();
//            result.setErrorCode();
        }
        return result;
    }

    /**
     * 增加菜单
     *
     * @param menuForm
     * @return
     */
    public Result saveMenu(MenuForm menuForm) {
        Result result = new Result(false);

        MenuDO menuDO = new MenuDO();

        try {

            BeanUtils.copyProperties(menuDO, menuForm);

            /*Timestamp timestamp = new Timestamp(new Date().getTime());
            menuDO.setGmtCreate(timestamp);
            menuDO.setGmtModified(timestamp);*/
            menuManager.addMenu(menuDO);

            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            result.setErrorMessage(e.getMessage());
            return result;
        }
    }

    /**
     * 修改菜单
     *
     * @param menuForm
     * @return
     */
    public Result updateMenu(MenuForm menuForm) {
        Result result = new Result(false);


        MenuDO menuDO = new MenuDO();

        try {
            BeanUtils.copyProperties(menuDO, menuForm);

             //已将下面的时间添加 延迟到manager层写入。
            /*Timestamp timestamp = new Timestamp(new Date().getTime());
            menuDO.setGmtModified(timestamp);*/

            menuManager.updateMenu(menuDO);

            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            result.setErrorMessage(e.getMessage());
            return result;
        }
    }

    /**
     * 删除菜单（通过ID）
     *
     * @param id
     * @return
     */
    public Result deleteMenu(Long id) {
        Result result = new Result(false);
        try {
            menuManager.deleteMenuById(id);

            result.setSuccess(true);
            return result;
        } catch (ManagerException e) {
            result.setErrorMessage(e.getMessage());
            return result;
        }
    }
}
