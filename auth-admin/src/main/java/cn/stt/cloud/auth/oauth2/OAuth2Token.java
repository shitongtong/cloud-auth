package cn.stt.cloud.auth.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName OAuth2Token
 * @Description 自定义 token 对象
 * @Author shitt7
 * @Date 2019/10/31 9:31
 * @Version 1.0
 */
public class OAuth2Token implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
