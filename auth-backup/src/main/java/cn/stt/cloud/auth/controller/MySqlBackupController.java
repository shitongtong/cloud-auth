package cn.stt.cloud.auth.controller;

import cn.stt.cloud.auth.config.BackupDataSourceProperties;
import cn.stt.cloud.auth.constant.BackupConstant;
import cn.stt.cloud.auth.response.Response;
import cn.stt.cloud.auth.service.MysqlBackupService;
import cn.stt.cloud.auth.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.stt.cloud.auth.response.Response.error;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @ClassName MySqlBackupController
 * @Description 系统数据备份还原 采用MYSQL备份还原命令
 * @Author shitt7
 * @Date 2019/11/5 13:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/backup")
public class MySqlBackupController {
    @Autowired
    MysqlBackupService mysqlBackupService;
    @Autowired
    BackupDataSourceProperties properties;

    @GetMapping("/backup")
    public ResponseEntity<Response> backup() {
        String host = properties.getHost();
        String userName = properties.getUserName();
        String password = properties.getPassword();
        String database = properties.getDatabase();
        String backupFodlerName = BackupConstant.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(BackupConstant.DATE_FORMAT)).format(new Date());
        String backupFolderPath = BackupConstant.BACKUP_FOLDER + backupFodlerName + File.separator;
        String fileName = BackupConstant.BACKUP_FILE_NAME;
        try {
            mysqlBackupService.backup(host, userName, password, backupFolderPath, fileName, database);
        } catch (Exception e) {
            return ok(error(500, e.getMessage()));
        }
        return ok(Response.success());
    }

    @GetMapping("/restore")
    public ResponseEntity<Response> restore(@RequestParam String name) {
        String host = properties.getHost();
        String userName = properties.getUserName();
        String password = properties.getPassword();
        String database = properties.getDatabase();
        String restoreFilePath = BackupConstant.RESTORE_FOLDER + name;
        try {
            mysqlBackupService.restore(restoreFilePath, host, userName, password, database);
        } catch (Exception e) {
            return ok(Response.error(500, e.getMessage()));
        }
        return ok(Response.success());
    }

    @GetMapping("/findRecords")
    public ResponseEntity<Response> findBackupRecords() {
        List<Map<String, Object>> backupRecords = new ArrayList<>();
        File restoreFolderFile = new File(BackupConstant.RESTORE_FOLDER);
        if (restoreFolderFile.exists()) {
            for (File file : restoreFolderFile.listFiles()) {
                Map<String, Object> bean = new HashMap<>();
                bean.put("name", file.getName());
                bean.put("title", file.getName());
                if (BackupConstant.DEFAULT_BACKUP_NAME.equals(file.getName())) {
                    bean.put("title", "系统默认备份");
                }
                backupRecords.add(bean);
            }
        }
        return ResponseEntity.ok(Response.success(backupRecords));
    }

    @GetMapping("/delete")
    public ResponseEntity<Response> deleteBackupRecord(@RequestParam String name) {
        if (BackupConstant.DEFAULT_BACKUP_NAME.equals(name)) {
            return ResponseEntity.ok(Response.errorCustom("系统默认备份无法删除!"));
        }
        String restoreFilePath = BackupConstant.RESTORE_FOLDER + name;
        try {
            FileUtil.deleteFile(new File(restoreFilePath));
        } catch (Exception e) {
            return ResponseEntity.ok(Response.error(500, e.getMessage()));
        }
        return ResponseEntity.ok(Response.success());
    }
}
