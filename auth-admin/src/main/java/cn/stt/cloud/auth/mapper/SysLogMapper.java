package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.SysLog;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLog record);
}