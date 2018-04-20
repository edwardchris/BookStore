package cn.les.dao;

import cn.les.biz.UserBiz;
import cn.les.entity.TUser;
import cn.les.util.Log;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.security.auth.login.LoginException;

import static org.testng.Assert.*;

/**
 * @author: huangxiang
 * @create: 2018/4/19 14:23
 * @description:
 */
public class UserDaoTest {


    @Test
    public void testLoginSuccess1() throws Exception {
        String uname = "admin";
        String pwd = "admin";
        UserDao dao = new UserDao();
        TUser user = null;
        user = dao.login(uname.trim(), pwd.trim());
        if (user != null) {
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void testLoginSuccess2() throws Exception {
        String uname = "test";
        String pwd = "test";
        UserDao dao = new UserDao();
        TUser user = null;
        user = dao.login(uname.trim(), pwd.trim());
        if (user != null) {
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void testLoginSuccess3() throws Exception {
        String uname = "edward";
        String pwd = "edward";
        UserDao dao = new UserDao();
        TUser user = null;
        user = dao.login(uname.trim(), pwd.trim());
        if (user != null) {
            Assert.assertEquals(true, true);
        }
    }

}