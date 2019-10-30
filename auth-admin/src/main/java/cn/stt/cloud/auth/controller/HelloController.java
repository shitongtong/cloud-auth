package cn.stt.cloud.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 15:33
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello cloud auth!";
    }
}
