package com.wasu.ptyw.crm.manager.impl;

import com.wasu.ptyw.common.exception.DAOException;
import com.wasu.ptyw.common.exception.ManagerException;
import com.wasu.ptyw.crm.dao.UserDAO;
import com.wasu.ptyw.crm.dataobject.UserDO;
import com.wasu.ptyw.crm.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDO login(UserDO userDO) throws ManagerException {
        try {
            UserDO result = userDAO.getByNameAndPassword(userDO);
            if (result == null) {
                throw new Exception();
            }
            return result;
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public boolean register(UserDO userDO) throws ManagerException {
        try {
            int number = userDAO.getByLoginName(userDO.getLoginName());
            if (number > 0) {
                //用户已存在
                return false;
            } else {
                Timestamp timestamp = new Timestamp(new Date().getTime());
                userDO.setGmtCreate(timestamp);
                userDO.setGmtModified(timestamp);

                int count = userDAO.save(userDO);
                if (count == 1) {
                    return true;
                }
                return false;
            }
        } catch (DAOException e) {
            throw new ManagerException(e);
        }
    }
}
