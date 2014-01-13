package com.wasu.ptyw.crm.ao;

import com.wasu.ptyw.common.dataobject.result.QueryResult;
import com.wasu.ptyw.common.dataobject.result.Result;
import com.wasu.ptyw.common.exception.ManagerException;
import com.wasu.ptyw.crm.constant.LoginConstant;
import com.wasu.ptyw.crm.dataobject.UserDO;
import com.wasu.ptyw.crm.dataobject.form.UserLoginForm;
import com.wasu.ptyw.crm.manager.UserManager;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

/**

 * @author: Jay
 * @Date: 14-1-9 上午11:05
 * Project: crm
 */
@Component
public class UserAO {

    @Autowired
    private UserManager userManager;


    /**
     * 通过用户登录表单VO来进行登录
     *
     * @param userLoginForm
     * @param response
     * @return
     */

    public QueryResult<UserDO> userLogin(UserLoginForm userLoginForm, HttpServletResponse response) {
        QueryResult<UserDO> result = new QueryResult<UserDO>(false);
        UserDO userDO=new UserDO();
        try {

            try {
                BeanUtils.copyProperties(userDO, userLoginForm);
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            userDO=userManager.login(userDO);

            //保存信息到session和cookie
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            HttpSession session = request.getSession();
            session.setAttribute(LoginConstant.SESSION_CRM_KEY, userDO);

            Cookie cookie = new Cookie(LoginConstant.COOKIE_LOGIN_KEY, String.valueOf(userDO.getId()));
            cookie.setPath(request.getContextPath());
            if(userLoginForm.isAutoLogin()){
                cookie.setMaxAge(LoginConstant.LOGIN_EXPIRE_TIME);
                session.setMaxInactiveInterval(LoginConstant.LOGIN_EXPIRE_TIME);

                //延长sessionid时间
                Cookie sid = new Cookie("JSESSIONID", session.getId());
                sid.setMaxAge(LoginConstant.LOGIN_EXPIRE_TIME);
                sid.setPath(request.getContextPath());
                response.addCookie(sid);
            }else{
                //浏览器关闭即退出
                cookie.setMaxAge(-1);
            }
            response.addCookie(cookie);


            result.setModel(userDO);
            result.setSuccess(true);
        } catch (ManagerException e) {
            result.setErrorMessage("用户不存在或密码错误！！");
        }
        return result;
    }

    /**
     *
     * 用户注册
     *
     * @param userDO
     * @return
     */

    public Result userRegister(UserDO userDO) {
        //To change body of created methods use File | Settings | File Templates.
        Result result = new Result(false);
        try {
            boolean flag = userManager.register(userDO);

            if(flag){
                result.setSuccess(true);
            }
            else{
                result.setErrorMessage("用户已存在 ！！");
            }
        } catch (ManagerException e) {
            result.setErrorMessage("系统出错了，请稍后尝试！");
        }
        return result;
    }
}
