package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);
}