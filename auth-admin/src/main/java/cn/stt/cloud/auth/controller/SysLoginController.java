package cn.stt.cloud.auth.controller;

import cn.stt.cloud.auth.entity.SysUser;
import cn.stt.cloud.auth.http.HttpResult;
import cn.stt.cloud.auth.request.LoginRequest;
import cn.stt.cloud.auth.security.JwtAuthenticatioToken;
import cn.stt.cloud.auth.service.SysUserService;
import cn.stt.cloud.auth.util.PasswordUtils;
import cn.stt.cloud.auth.util.SecurityUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName SysLoginController
 * @Description 登录控制器
 * @Author shitt7
 * @Date 2019/10/30 15:33
 * @Version 1.0
 */
@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 获取验证码
     *
     * @param response
     * @param httpServletRequest
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest httpServletRequest) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        httpServletRequest.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口 admin/admin
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginRequest request, HttpServletRequest httpServletRequest) throws IOException {
        String username = request.getAccount();
        String password = request.getPassword();
        String captcha = request.getCaptcha();

        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = httpServletRequest.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
//            return ResponseEntity.ok(Response.errorCustom("验证码已失效"));
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
//            return ResponseEntity.ok(Response.errorCustom("验证码不正确"));
            return HttpResult.error("验证码不正确");
        }

        // 用户信息
        SysUser user = sysUserService.findByName(username);

        // 账号不存在、密码错误
        if (user == null) {
//            return ResponseEntity.ok(Response.errorCustom("账号不存在"));
            return HttpResult.error("账号不存在");
        }

        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }

        // 账号锁定
//        if (user.getUserStatus() == 0) {
//            return ResponseEntity.ok(Response.errorCustom("账号已被锁定,请联系管理员"));
//        }

        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }

        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(httpServletRequest, username, password, authenticationManager);

        return HttpResult.ok(token);
    }

}
