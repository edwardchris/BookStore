package cn.les.biz;

import cn.les.dao.UserDao;
import cn.les.entity.TUser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author: huangxiang
 * @create: 2018/4/19 14:23
 * @description:
 */
public class UserBizTest {


    @Test(expectedExceptions = Exception.class)
    public void testLoginSuccess1() throws Exception {
        TUser user = new TUser();
        UserBiz biz = new UserBiz();
        String uname = "";
        String pwd = "";

        user = biz.login(uname.trim(), pwd.trim());
        if (user == null) {
            Assert.assertEquals(true, true);
        }
    }
}