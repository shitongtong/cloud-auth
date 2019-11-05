package cn.stt.cloud.auth.service.impl;

import cn.stt.cloud.auth.service.MysqlBackupService;
import cn.stt.cloud.auth.util.MySqlBackupRestoreUtil;
import org.springframework.stereotype.Service;

/**
 * @ClassName MysqlBackupServiceImpl
 * @Description TODO
 * @Author shitt7
 * @Date 2019/11/5 13:51
 * @Version 1.0
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {
    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
        return MySqlBackupRestoreUtil.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        return MySqlBackupRestoreUtil.restore(restoreFilePath, host, userName, password, database);
    }
}
