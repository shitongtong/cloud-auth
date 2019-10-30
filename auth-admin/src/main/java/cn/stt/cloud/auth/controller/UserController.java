package cn.stt.cloud.auth.controller;

import cn.stt.cloud.auth.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 16:47
 * @Version 1.0
 */
@Api(value = "用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息", notes = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping(value = "/findById")
    public Object findById(@RequestParam Integer id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return userService.findAll();
    }
}
