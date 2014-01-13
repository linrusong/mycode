package com.wasu.ptyw.crm.interceptor;


import com.wasu.ptyw.crm.constant.LoginConstant;
import com.wasu.ptyw.crm.dataobject.UserDO;
import com.wasu.ptyw.crm.dataobject.login.LoginUser;
import com.wasu.ptyw.crm.util.WhiteListPropertiesUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证过滤器
 *
 * @author 林汝松
 * @date 2013-4-15
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    protected Log log = LogFactory.getLog(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        // 白名单验证
        String url = request.getServletPath();
        boolean isWhiteList = WhiteListPropertiesUtil.check(url);
        if (isWhiteList) {
            return true;
        }

        UserDO userDO = (UserDO) session .getAttribute(LoginConstant.SESSION_CRM_KEY);
        if (userDO == null) {// 登录不通过
            response.sendRedirect(request.getContextPath() + "/login.htm");
            return false;
        }

        // 往threadlocal中写值
        LoginUser loginUser = buildUserSession(userDO);
        LoginUser.setCurrentUser(loginUser);
        request.setAttribute("user", loginUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 业务执行结束清除
        LoginUser.remove();
    }

    /**
     * @param userDO
     * @return
     */
    private LoginUser buildUserSession(UserDO userDO) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(userDO.getId());
        loginUser.setLoginName(userDO.getLoginName());
        loginUser.setUsername(userDO.getUsername());
        return loginUser;
    }

}
