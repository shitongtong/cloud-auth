package cn.stt.cloud.auth.service.impl;

import cn.stt.cloud.auth.entity.Menu;
import cn.stt.cloud.auth.entity.User;
import cn.stt.cloud.auth.mapper.UserMapper;
import cn.stt.cloud.auth.service.MenuService;
import cn.stt.cloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private MenuService menuService;

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public Set<String> findPermissions(String name) {
        Set<String> perms = new HashSet<>();
        List<Menu> menuList = menuService.findByUserName(name);
        for (Menu menu : menuList) {
            if (menu.getPerms() != null && !"".equals(menu.getPerms())) {
                perms.add(menu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
