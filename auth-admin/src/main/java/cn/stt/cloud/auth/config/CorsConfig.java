package cn.stt.cloud.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsConfig
 * @Description 跨域配置
 * @Author shitt7
 * @Date 2019/11/5 9:24
 * @Version 1.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 解决跨域问题
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书(发送cookie) 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 允许头部设置
                .allowedHeaders("*")
                //跨域允许时间
                .maxAge(3600);
    }
}
