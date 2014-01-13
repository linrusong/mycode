package com.wasu.ptyw.crm.util;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:�����������ļ���ȡ��
 */
public class WhiteListPropertiesUtil {


    /**
     * @Fields FILENAME : �����ļ���
     */
    private static final String FILENAME = "properties/whitelist.properties";

    /**
     * : ����������
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
            System.out.println("��ȡwhitelist.properties����");
        }
    }

    /**
     * ��ȡ���а�����url
     *
     * @return
     */
    public static List<String> getAllWhiteList() {
        return whiteList;
    }

    /**
     * ֧��"/login*"��ƥ�����ֻ֧��*�ĺ�ƥ��
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
     * ��֤url�Ƿ��ڰ�������
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
