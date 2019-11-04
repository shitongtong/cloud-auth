package cn.stt.cloud.auth.service;

import cn.stt.cloud.auth.entity.UserToken;

/**
 * @ClassName UserTokenService
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/31 9:43
 * @Version 1.0
 */
public interface UserTokenService {
    /**
     * 根据token查找
     *
     * @param token
     * @return
     */
    UserToken findByToken(String token);

    UserToken createToken(Integer userId);

    UserToken findByUserId(Integer userId);

    int save(UserToken userToken);
}
