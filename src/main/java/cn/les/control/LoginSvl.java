package cn.les.control;

import cn.les.biz.UserBiz;
import cn.les.entity.TUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: huangxiang
 * @create: 2018/4/18 16:39
 * @description:
 */

public class LoginSvl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        UserBiz biz = new UserBiz();
        try {
            TUser user = biz.login(uname, pwd);
            if (user != null){
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/main/main.jsp").forward(request, response);
            }else {
                request.setAttribute("msg","用户名或密码输入错误");
                request.getRequestDispatcher("WEB-INF/main/login.jsp").forward(request, response);
            }


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg","网络异常，请联系管理员！");
            request.getRequestDispatcher("WEB-INF/error/error.jsp").forward(request,response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/main/login.jsp").forward(request,response);
    }
}
