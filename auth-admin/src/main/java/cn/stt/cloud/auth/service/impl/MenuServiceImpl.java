package cn.stt.cloud.auth.service.impl;

import cn.stt.cloud.auth.entity.Menu;
import cn.stt.cloud.auth.mapper.MenuMapper;
import cn.stt.cloud.auth.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 18:53
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public PageSerializable<Menu> pageAll(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Menu> menuList = menuMapper.selectAll();
        return new PageSerializable<>(menuList);
    }
}
