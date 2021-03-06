package com.wasu.ptyw.crm.util;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:白名单属性文件读取类
 */
public class WhiteListPropertiesUtil {


    /**
     * @Fields FILENAME : 属性文件名
     */
    private static final String FILENAME = "properties/whitelist.properties";

    /**
     * : 白名单对象
     */
    private static List<String> whiteList;

    static {
        try {

            whiteList = new ArrayList<String>();
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream(FILENAME);
            BufferedReader br = null;
            String msg = null;
            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((msg = br.readLine()) != null) {
                msg = msg.trim();
                whiteList.add(msg);
            }
        } catch (IOException e) {
            System.out.println("读取whitelist.properties出错");
        }
    }

    /**
     * 获取所有白名单url
     *
     * @return
     */
    public static List<String> getAllWhiteList() {
        return whiteList;
    }

    /**
     * 支持"/login*"的匹配规则，只支持*的后匹配
     */
    public static boolean matchFiltersURL(String pattern, String requestPath) {

        if (requestPath == null)
            return (false);

        if (pattern == null)
            return (false);

        if (pattern.equals(requestPath))
            return (true);

        if (pattern.equals("*"))
            return (true);
        if (pattern.endsWith("*")) {
            return pattern.regionMatches(0, requestPath, 0, pattern.length() - 1);
        }

        return (false);

    }

    /**
     * 验证url是否在白名单中
     *
     * @param url
     * @return
     */
    public static boolean check(String url) {
        if (whiteList == null || whiteList.size() == 0) {
            return false;
        }

        if (StringUtils.isBlank(url)) {
            return false;
        }

        for (String pattern : whiteList) {
            if (matchFiltersURL(pattern, url)) {
                return true;
            }
        }

        return false;
    }

}

