package com.wasu.ptyw.crm.manager.impl;

import com.wasu.ptyw.common.exception.ManagerException;
import com.wasu.ptyw.crm.dao.MenuDAO;
import com.wasu.ptyw.crm.dataobject.MenuDO;
import com.wasu.ptyw.crm.dataobject.form.MenuQuery;
import com.wasu.ptyw.crm.manager.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ¡÷»ÍÀ…
 * @Date: 13-12-23  œ¬ŒÁ2:32
 */
@Component
public class MenuManagerImpl implements MenuManager {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<MenuDO> queryMenuList(MenuQuery menuQuery) throws ManagerException {
        try {
            Integer rowCount = menuDAO.getMenuCount(menuQuery);
            if (rowCount == null || rowCount <= 0) {
                return new ArrayList<MenuDO>(0);
            } else {
                menuQuery.setTotalItem(rowCount);
                return menuDAO.searchAndSort(menuQuery);

            }
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public List<MenuDO> queryAllMenuTree() throws ManagerException {
        try {
            List<MenuDO> list = menuDAO.getAllMenu();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ManagerException();
        }
    }

    @Override
    public void updateMenu(MenuDO menuDO) throws ManagerException {
        try {
            menuDO.setGmtModified(new Timestamp(new Date().getTime()));
            menuDAO.update(menuDO);  //To change body of implemented methods use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();
            throw new ManagerException();
        }
    }

    @Override
    public void deleteMenuById(Long id) throws ManagerException {
        try {
            menuDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ManagerException();
        }
    }

    @Override
    public void addMenu(MenuDO menuDO) throws ManagerException {
        try {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            menuDO.setGmtCreate(timestamp);
            menuDO.setGmtModified(timestamp);
            menuDAO.save(menuDO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ManagerException();
        }
    }
}
