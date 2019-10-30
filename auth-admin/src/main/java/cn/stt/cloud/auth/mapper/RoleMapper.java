package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);
}