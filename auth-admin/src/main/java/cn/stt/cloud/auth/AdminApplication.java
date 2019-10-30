package cn.stt.cloud.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName AdminApplication
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 15:29
 * @Version 1.0
 */
@MapperScan("cn.stt.cloud.auth.mapper")
@SpringBootApplication
public class AdminApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        LOGGER.info("容器启动成功!");
    }
}
