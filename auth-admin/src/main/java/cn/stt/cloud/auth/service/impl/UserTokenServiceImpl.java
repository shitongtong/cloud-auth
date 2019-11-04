package cn.stt.cloud.auth.service.impl;

import cn.stt.cloud.auth.entity.UserToken;
import cn.stt.cloud.auth.mapper.UserTokenMapper;
import cn.stt.cloud.auth.service.UserTokenService;
import cn.stt.cloud.auth.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName UserTokenServiceImpl
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/31 9:43
 * @Version 1.0
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {
    // 12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public UserToken findByToken(String token) {
        return userTokenMapper.findByToken(token);
    }

    @Override
    public UserToken createToken(Integer userId) {
        // 生成一个token
        String token = TokenGenerator.generateToken();
        // 当前时间
        Date now = new Date();
        // 过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        // 判断是否生成过token
        UserToken userToken = findByUserId(userId);
        if (userToken == null) {
            userToken = new UserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setExpireTime(expireTime);
            // 保存token，这里选择保存到数据库，也可以放到Redis或Session之类可存储的地方
            save(userToken);
        } else {
            userToken.setToken(token);
            userToken.setExpireTime(expireTime);
            // 如果token已经生成，则更新token的过期时间
            save(userToken);
        }
        return userToken;
    }

    @Override
    public UserToken findByUserId(Integer userId) {
        return userTokenMapper.findByUserId(userId);
    }

    @Override
    public int save(UserToken userToken) {
        if (userToken.getId() == null || userToken.getId() == 0) {
            return userTokenMapper.insertSelective(userToken);
        }
        return userTokenMapper.updateByPrimaryKeySelective(userToken);
    }
}
