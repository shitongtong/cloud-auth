package cn.stt.cloud.auth.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

import java.util.UUID;

/**
 * @ClassName PasswordUtil
 * @Description 密码工具类
 * @Author shitt7
 * @Date 2019/11/1 14:46
 * @Version 1.0
 */
public class PasswordUtil {
    /**
     * 匹配密码
     * @param password
     * @param salt
     * @param encryptePassword
     * @return
     */
    public static boolean match(String password, String salt, String encryptePassword) {
        if(password != null && encrypte(password, salt).equals(encryptePassword)) {
            return true;
        }
        return false;
    }

    /**
     * 明文密码加密
     * @param password
     * @param salt
     * @return
     */
    public static String encrypte(String password, String salt) {
        return new Sha256Hash(password, salt).toHex();
    }

    /**
     * 获取加密盐
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
