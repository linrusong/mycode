package com.wasu.ptyw.crm.manager;

import com.wasu.ptyw.common.exception.ManagerException;
import com.wasu.ptyw.crm.dataobject.MenuDO;
import com.wasu.ptyw.crm.dataobject.form.MenuQuery;

import java.util.List;

/**
 * @author: 李杰
 * @Date: 13-12-23  下午2:29
 */
public interface MenuManager {

    /**
     * 查询所有的菜单列表
     *
     * @return
     * @throws ManagerException
     */
    List<MenuDO> queryMenuList(MenuQuery menuQuery) throws ManagerException;

    List<MenuDO> queryAllMenuTree() throws ManagerException;

    void updateMenu(MenuDO menuDO) throws ManagerException;

    void deleteMenuById(Long id) throws ManagerException;

    void addMenu(MenuDO menuDO) throws ManagerException;
}
