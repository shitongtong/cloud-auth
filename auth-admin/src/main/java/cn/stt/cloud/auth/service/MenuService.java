package cn.stt.cloud.auth.service;

import cn.stt.cloud.auth.entity.Menu;
import com.github.pagehelper.PageSerializable;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 18:47
 * @Version 1.0
 */
public interface MenuService {

    /**
     * 分页查找菜单
     *
     * @return
     */
    PageSerializable<Menu> pageAll(int pageNo, int pageSize);
}