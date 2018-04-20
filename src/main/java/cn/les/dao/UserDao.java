package cn.les.dao;

import cn.les.constants.IRole;
import cn.les.entity.TUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author hx
 * @description UserDao
 * @create 2017-11-10 9:10
 **/
public class UserDao extends BaseDao {
    /**
     * @param uName
     * @param pwd
     * @return
     * @throws Exception
     */

    public TUser login(String uName, String pwd) throws Exception {
        /**
         * @Author:huangxiang
         * @Date: 下午4:36 2018/4/18
         * @param uName
          * @param pwd
         * @Description:
         * @method: login
         * @return: cn.les.entity.TUser
         */
        TUser tUser = null;
        String sql = "select * from  TUSER where UNAME=? and PWD = ?";
        this.openConnection();
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, uName);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            tUser = new TUser();
            tUser.setuName(uName);
            tUser.setPwd(pwd);
            tUser.setRole(rs.getInt("role"));
            break;
        }
        rs.close();
        ps.close();
        return tUser;
    }


}
