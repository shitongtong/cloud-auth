package cn.stt.cloud.auth;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
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
@EnableAdminServer
@SpringBootApplication
public class MonitorApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
        LOGGER.info("容器启动成功!");
    }
}
