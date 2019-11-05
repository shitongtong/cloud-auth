package cn.stt.cloud.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName BackupDataSourceProperties
 * @Description TODO
 * @Author shitt7
 * @Date 2019/11/5 9:40
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "spring.backup.datasource")
@Data
public class BackupDataSourceProperties {
    private String host;
    private String userName;
    private String password;
    private String database;
}
