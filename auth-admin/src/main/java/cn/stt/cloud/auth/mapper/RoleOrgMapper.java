package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.RoleOrg;

public interface RoleOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(RoleOrg record);

    RoleOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleOrg record);
}