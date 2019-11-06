package cn.stt.cloud.auth.request;

import lombok.Data;

/**
 * @ClassName LoginRequest
 * @Description TODO
 * @Author shitt7
 * @Date 2019/11/1 14:36
 * @Version 1.0
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
    private String captcha;
}
