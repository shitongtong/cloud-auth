package cn.stt.cloud.auth.service.impl;

import cn.stt.cloud.auth.entity.User;
import cn.stt.cloud.auth.mapper.UserMapper;
import cn.stt.cloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 16:46
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
