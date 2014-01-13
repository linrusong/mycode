package com.wasu.ptyw.crm.dataobject.login;

import lombok.Data;

import java.io.Serializable;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */

@Data
public class LoginUser implements Serializable {

    /**
     * 用户信息存放，用户可以不从session中取而从threadlocal中取，可以减少参数传递，
     * 而且可以保存一些session没有的用户信息关系。
     */
    private static final ThreadLocal<LoginUser> loginUserHold = new ThreadLocal<LoginUser>();

    private Long id;

    private String loginName;

    private String username;


    /**
     * 获取当前线程中的用户对象
     * @return
     */
    public static final LoginUser getCurrentUser() {
        return (LoginUser) loginUserHold.get();
    }

    /**
     * 设置当前线程的用户对象
     * @param user
     */
    public static final void setCurrentUser(LoginUser user) {
        loginUserHold.set(user);
    }

    /**
     * 移出当前线程用户对象
     */
    public static final void remove(){
        loginUserHold.remove();
    }

}
