package com.wasu.ptyw.crm.dao;

import com.wasu.ptyw.common.exception.DAOException;
import com.wasu.ptyw.crm.dataobject.MenuDO;
import com.wasu.ptyw.crm.dataobject.form.MenuQuery;

import java.util.List;


/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 ионГ11:05
 * Project: crm
 */
public interface MenuDAO extends CrudDAO {




    List<MenuDO> searchAndSort(MenuQuery menuQuery) throws DAOException;

    List<MenuDO> getAllMenu() throws DAOException;

    Integer getMenuCount(MenuQuery menuQuery) throws DAOException;

}
