package com.wasu.ptyw.crm.dataobject.form;

import com.alibaba.fastjson.JSON;
import com.wasu.ptyw.common.dataobject.Query;
import lombok.Data;

import java.util.Date;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */

@Data
public class MenuQuery extends Query{


    private String sort;

    private String order;

    private Long id;

    private Long pid;

    private String name;

    private String code;

    private String url;

    private Short isLeaf;

    private Short status;

    private Date gmtCreate;

    private Date gmtModified;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
