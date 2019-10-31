package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    /**
     * 分页查询
     * @return
     */
    List<Menu> selectAll();
}