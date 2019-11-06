package cn.stt.cloud.auth.util;

import cn.stt.cloud.auth.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName ShiroUtil
 * @Description Shiro相关工具类
 * @Author shitt7
 * @Date 2019/11/6 10:44
 * @Version 1.0
 */
public class ShiroUtil {
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static User getUser() {
        Object user = SecurityUtils.getSubject().getPrincipal();
        return user == null ? null : ((User) user);
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }
}
