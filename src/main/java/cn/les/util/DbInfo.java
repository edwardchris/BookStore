package cn.les.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author hx
 * @description DbInfo
 * @create 2017-11-14 14:48
 **/
public class DbInfo {
    /**
     * 单例模式，不用二次创建对象
     */
    public static DbInfo dbInfo;

    private DbInfo() {

    }

    /**
     * 单例的对外接口，如果单例对象为空，创建新的单例对象,针对并发情况的synchronized机制
     *
     * @return
     */
    public static synchronized DbInfo instance() throws Exception {
        if (dbInfo == null) {
            dbInfo = new DbInfo();
            dbInfo.init();
        }
        return dbInfo;
    }

    /**
     * 读取配置文件，给属性初始化
     */
    private void init() throws Exception {
        String filePath = DbInfo.class.getResource("/").toURI().getPath() + "db.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(filePath)));
        this.dbDriver = properties.getProperty("dbDriver");
        this.dbURL = properties.getProperty("dbURL");
        this.uName = properties.getProperty("uName");
        this.pwd = properties.getProperty("pwd");
    }

    private String dbDriver;
    private String dbURL;
    private String uName;
    private String pwd;

    public String getDbDriver() {
        return dbDriver;
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getuName() {
        return uName;
    }

    public String getPwd() {
        return pwd;
    }
}
