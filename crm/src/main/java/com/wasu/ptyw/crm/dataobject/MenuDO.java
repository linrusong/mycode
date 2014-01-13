package com.wasu.ptyw.crm.dataobject;

import com.alibaba.fastjson.JSON;
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
public class MenuDO {
    private Long id;

    private Long pid;

    private String name;

    private String code;

    private String url;

    private int isLeaf;

    private int status;

    private Date gmtCreate;

    private Date gmtModified;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}