package cn.stt.cloud.auth.controller;

import cn.stt.cloud.auth.entity.Menu;
import cn.stt.cloud.auth.request.PageRequest;
import cn.stt.cloud.auth.response.Response;
import cn.stt.cloud.auth.service.MenuService;
import com.github.pagehelper.PageSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MenuController
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 18:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public ResponseEntity<Response> list(PageRequest request) {
        int pageNo = request.getPageNo();
        int pageSize = request.getPageSize();
        PageSerializable<Menu> page = menuService.pageAll(pageNo, pageSize);
        return ResponseEntity.ok(Response.success(page));
    }
}
