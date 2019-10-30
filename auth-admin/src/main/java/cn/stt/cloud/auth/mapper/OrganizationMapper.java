package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);
}