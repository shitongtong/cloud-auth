package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);
}