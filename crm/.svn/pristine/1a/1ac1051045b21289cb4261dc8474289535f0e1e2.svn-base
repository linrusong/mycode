package com.wasu.ptyw.crm.dao;

import com.wasu.ptyw.common.exception.DAOException;
import com.wasu.ptyw.crm.dataobject.UserDO;


/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 ионГ11:05
 * Project: crm
 */
public interface UserDAO extends CrudDAO {

    UserDO getByNameAndPassword(UserDO userDO) throws DAOException;

    int getByLoginName(String loginName) throws DAOException;


}