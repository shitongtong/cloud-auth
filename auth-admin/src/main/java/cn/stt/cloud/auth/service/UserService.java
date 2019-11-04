package cn.stt.cloud.auth.service;

import cn.stt.cloud.auth.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 16:44
 * @Version 1.0
 */
public interface UserService {

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据用户名查找用户的菜单权限标识集合
     *
     * @param name
     * @return
     */
    Set<String> findPermissions(String name);

    User findByName(String name);
}
