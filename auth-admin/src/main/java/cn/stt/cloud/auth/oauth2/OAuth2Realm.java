package cn.stt.cloud.auth.oauth2;

import cn.stt.cloud.auth.entity.User;
import cn.stt.cloud.auth.entity.UserToken;
import cn.stt.cloud.auth.service.UserService;
import cn.stt.cloud.auth.service.UserTokenService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @ClassName OAuth2Realm
 * @Description 认证Realm实现
 * @Author shitt7
 * @Date 2019/10/31 9:40
 * @Version 1.0
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private UserTokenService userTokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(接口保护，验证接口调用权限时调用)
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        // 用户权限列表，根据用户拥有的权限标识与如 @permission标注的接口对比，决定是否可以调用接口
        Set<String> permsSet = userService.findPermissions(user.getName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        // 根据accessToken，查询用户token信息
        UserToken userToken = userTokenService.findByToken(token);
        if (userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()) {
            // token已经失效
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        // 查询用户信息
        User user = userService.findById(userToken.getUserId());
        // 账号被锁定
        if (user.getUserStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token, getName());
        return info;
    }
}
