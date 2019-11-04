package cn.stt.cloud.auth.util;

import cn.stt.cloud.auth.exception.BusinessException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @ClassName TokenGenerator
 * @Description token 生成器
 * @Author shitt7
 * @Date 2019/11/1 14:54
 * @Version 1.0
 */
public class TokenGenerator {
    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String generateToken() {
        return generateValue(UUID.randomUUID().toString());
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new BusinessException("生成Token失败", e);
        }
    }

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }
}
