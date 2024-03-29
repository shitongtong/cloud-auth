package cn.stt.cloud.auth.service.impl;


import cn.stt.cloud.auth.service.MysqlBackupService;
import cn.stt.cloud.auth.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;


@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {

    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
                          String database) throws Exception {
        return MySqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database)
            throws Exception {
        return MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }

}
