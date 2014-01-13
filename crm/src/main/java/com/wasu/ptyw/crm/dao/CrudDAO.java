package com.wasu.ptyw.crm.dao;

import com.wasu.ptyw.common.dataobject.Query;
import com.wasu.ptyw.common.exception.DAOException;

import java.util.List;

/**
 * @author: ¡÷»ÍÀ…
 * @Date: 14-1-9  …œŒÁ9:53
 */
public interface CrudDAO {

    int save(Object record) throws DAOException;

    int update(Object record) throws DAOException;

    int delete(Long id) throws DAOException;

    Object get(Long id) throws DAOException;

//    Long getCount(Query query) throws DAOException;

    List list(Query query) throws DAOException;
}
