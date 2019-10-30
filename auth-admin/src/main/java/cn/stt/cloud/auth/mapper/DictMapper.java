package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.Dict;

public interface DictMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dict record);
}