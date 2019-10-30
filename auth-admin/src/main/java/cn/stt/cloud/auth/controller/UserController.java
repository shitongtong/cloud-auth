package cn.stt.cloud.auth.controller;

import cn.stt.cloud.auth.service.UserService;
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
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findById")
    public Object findById(@RequestParam Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return userService.findAll();
    }
}
