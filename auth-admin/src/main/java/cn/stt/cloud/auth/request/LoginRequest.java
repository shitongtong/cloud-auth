package cn.stt.cloud.auth.request;

import lombok.Data;

/**
 * @ClassName LoginRequest
 * @Description 登录接口封装对象
 * @Author shitt7
 * @Date 2019/11/1 14:36
 * @Version 1.0
 */
@Data
public class LoginRequest {
    private String account;
    private String password;
    private String captcha;
}
