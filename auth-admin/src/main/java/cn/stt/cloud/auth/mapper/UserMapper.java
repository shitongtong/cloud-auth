package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    /**
     * 查询全部
     * @return
     */
    List<User> selectAll();

    User findByName(String name);
}