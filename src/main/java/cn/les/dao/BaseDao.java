package cn.les.dao;


import cn.les.util.DbInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hx
 * @Description 连接数据库父类
 * @create 2017-10-20 14:13
 **/
public abstract class BaseDao {
    protected Connection connection;


    public Connection getConnection() {
        try {
            this.openConnection();
        } catch (Exception e) {
           // Log.getLogger().error(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * 打开数据库连接,检查数据库连接
     */
    public void openConnection() throws Exception {

        try {
            if (connection == null || connection.isClosed()) {
                DbInfo dbInfo = DbInfo.instance();
                Class.forName(dbInfo.getDbDriver());
                //从数据库底层获得一个新的connection
                connection = DriverManager.getConnection(dbInfo.getDbURL(), dbInfo.getuName(), dbInfo.getPwd());
            }
            //反射检查驱动包是否存在
        } catch (ClassNotFoundException e) {
           // Log.getLogger().error(e.getMessage() + "--- 请检查数据驱动");
            e.printStackTrace();
        } catch (SQLException e) {
            //Log.getLogger().error(e.getMessage() + "--- 请检查数据库连接地址");
            e.printStackTrace();
        }
    }

    /**
     * 异常不需要抛出，只记录
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
               // Log.getLogger().error(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    /**
     * 打开事务
     */
    public void startTransaction() throws Exception {
        this.openConnection();
        this.connection.setAutoCommit(false);
    }

    /**
     * 重写commit方法
     *
     * @throws Exception
     */
    public void commit() throws Exception {
        if (this.connection != null) {
            this.connection.commit();
        }
    }


    /**
     * 重写rollback方法
     *
     * @throws Exception
     */
    public void rollBack() throws Exception {
        if (this.connection != null) {
            this.connection.rollback();
        }
    }


}

