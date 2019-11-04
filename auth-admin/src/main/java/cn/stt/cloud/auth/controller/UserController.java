package cn.stt.cloud.auth.controller;

import cn.stt.cloud.auth.entity.User;
import cn.stt.cloud.auth.entity.UserToken;
import cn.stt.cloud.auth.request.LoginRequest;
import cn.stt.cloud.auth.response.Response;
import cn.stt.cloud.auth.service.UserService;
import cn.stt.cloud.auth.service.UserTokenService;
import cn.stt.cloud.auth.util.PasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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
    @Autowired
    private UserTokenService userTokenService;

    @ApiOperation(value = "获取用户信息", notes = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping(value = "/findById")
    public ResponseEntity<Response> findById(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(Response.success(user));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<Response> findAll() {
        List<User> userList = userService.findAll();
        return ResponseEntity.ok(Response.success(userList));
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest request) throws IOException {
        String username = request.getUsername();
        String password = request.getPassword();

        // 用户信息
        User user = userService.findByName(username);

        // 账号不存在、密码错误
        if (user == null) {
            return ResponseEntity.ok(Response.errorCustom("账号不存在"));
        }

        if (!match(user, password)) {
            return ResponseEntity.ok(Response.errorCustom("密码不正确"));
        }

        // 账号锁定
        if (user.getUserStatus() == 0) {
            return ResponseEntity.ok(Response.errorCustom("账号已被锁定,请联系管理员"));
        }

        // 生成token，并保存到数据库
        UserToken userToken = userTokenService.createToken(user.getId());
        return ResponseEntity.ok(Response.success(userToken));
    }

    /**
     * 验证用户密码
     *
     * @param user
     * @param password
     * @return
     */
    public boolean match(User user, String password) {
        return user.getPassword().equals(PasswordUtil.encrypte(password, user.getSalt()));
    }

}
