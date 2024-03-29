package cn.stt.cloud.auth.constant;

import java.io.File;

/**
 * @ClassName BackupConstant
 * @Description 备份项目常量类
 * @Author shitt7
 * @Date 2019/11/5 14:24
 * @Version 1.0
 */
public class BackupConstant {
    /**
     * 备份目录名称
     */
    public static final String BACKUP_FOLDER_NAME = "_kitty_backup";
    /**
     * 备份目录
     */
    public static final String BACKUP_FOLDER = System.getProperty("user.home") + File.separator + BACKUP_FOLDER_NAME + File.separator;
    /**
     * 还原目录，默认就是备份目录
     */
    public static final String RESTORE_FOLDER = BACKUP_FOLDER;
    /**
     * 日期格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd_HHmmss";
    /**
     * SQL拓展名
     */
    public static final String SQL_EXT = ".sql";
    /**
     * 默认备份文件名
     */
    public static final String BACKUP_FILE_NAME = "kitty" + SQL_EXT;
    /**
     * 默认备份还原目录名称
     */
    public static final String DEFAULT_BACKUP_NAME = "backup";
    /**
     * 默认备份还原文件
     */
    public static final String DEFAULT_RESTORE_FILE = BACKUP_FOLDER + DEFAULT_BACKUP_NAME + File.separator + BACKUP_FILE_NAME;

}
