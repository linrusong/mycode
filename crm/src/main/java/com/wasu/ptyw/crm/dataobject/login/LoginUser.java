package com.wasu.ptyw.crm.dataobject.login;

import lombok.Data;

import java.io.Serializable;

/**
 * .
 *
 * @author: Jay
 * @Date: 14-1-9 ����11:05
 * Project: crm
 */

@Data
public class LoginUser implements Serializable {

    /**
     * �û���Ϣ��ţ��û����Բ���session��ȡ����threadlocal��ȡ�����Լ��ٲ������ݣ�
     * ���ҿ��Ա���һЩsessionû�е��û���Ϣ��ϵ��
     */
    private static final ThreadLocal<LoginUser> loginUserHold = new ThreadLocal<LoginUser>();

    private Long id;

    private String loginName;

    private String username;


    /**
     * ��ȡ��ǰ�߳��е��û�����
     * @return
     */
    public static final LoginUser getCurrentUser() {
        return (LoginUser) loginUserHold.get();
    }

    /**
     * ���õ�ǰ�̵߳��û�����
     * @param user
     */
    public static final void setCurrentUser(LoginUser user) {
        loginUserHold.set(user);
    }

    /**
     * �Ƴ���ǰ�߳��û�����
     */
    public static final void remove(){
        loginUserHold.remove();
    }

}
