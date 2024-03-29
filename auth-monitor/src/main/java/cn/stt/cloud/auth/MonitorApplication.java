package cn.stt.cloud.auth;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName AdminApplication
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/30 15:29
 * @Version 1.0
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class MonitorApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MonitorApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        LOGGER.info("容器启动成功!");
    }
}
