package cn.les.biz;

import cn.les.dao.UserDao;
import cn.les.entity.TUser;

/**
 * @author hx
 * @description UserBiz
 * @create 2017-11-10 9:09
 **/
public class UserBiz {
    /**
     * @param uName
     * @param pwd
     * @return
     * @throws Exception
     */

    public TUser login(String uName, String pwd) throws Exception {
        /**
         * @Author:huangxiang
         * @Date: 下午4:32 2018/4/18
         * @param uName
          * @param pwd
         * @Description:
         * @method: login
         * @return: cn.les.entity.TUser
         */
        TUser user = null;
        /**
         * 空指针判断在前，空字符串判断在后（Java的短路设计））
         */
        if (uName != null && pwd != null && !"".equals(uName.trim()) && !"".equals(pwd.trim())) {
            UserDao dao = new UserDao();
            try {
                user = dao.login(uName, pwd);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                dao.closeConnection();
            }

        } else {
            throw new Exception("入参错误，请检查！");

        }

        return user;
    }
}
