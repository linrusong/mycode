package com.wasu.ptyw.crm.dataobject;

import lombok.Data;

import java.util.Date;


/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 ионГ11:05
 * Project: crm
 */
@Data
public class UserDO {
    private Long id;

    private String loginName;

    private String password;

    private String username;

    private int status;

    private Date gmtCreate;

    private Date gmtModified;


}