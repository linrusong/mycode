package com.wasu.ptyw.crm.dataobject.form;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 ионГ11:05
 * Project: crm
 */
@Data
public class MenuForm {
    private Long id;

    private Long pid;

    private String name;

    private String code;

    private String url;

    private Short isLeaf;

    private Short status;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
