package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.RoleMenu;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenu record);
}