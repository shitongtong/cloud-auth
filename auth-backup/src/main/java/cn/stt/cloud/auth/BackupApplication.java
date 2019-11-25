package cn.stt.cloud.auth;

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
@SpringBootApplication
public class BackupApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackupApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BackupApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        LOGGER.info("容器启动成功!");
    }
}
