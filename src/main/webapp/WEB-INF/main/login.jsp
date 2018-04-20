<%--
  Created by IntelliJ IDEA.
  User: huangxiang
  Date: 2018/4/18
  Time: 下午3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录页</title>
    <script type="text/javascript">

        function tijiao(){
            var tishi = document.getElementById("tishi");
            var uname = document.getElementById("uname").value;
            if(uname.trim()==''){

                tishi.innerHTML="用户名不能为空";
                return false;
            }
            var pwd = document.getElementById("pwd").value;
            if(pwd.trim() == ''){

                tishi.innerHTML="密码不能为空";
                return false;
            }
            //debugger;
            //console.log("uname=" + uname);
            var myform = document.getElementById("myform");
            myform.submit();
        }

    </script>
 </head>
<body>
<form id="myform" action="<%=basePath%>LoginSvl" method="post">
    <table align="center">
        <tr height="200"></tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="uname" id="uname"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd" id="pwd"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="button" value="提交" onclick="tijiao()" ></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                ${msg}
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <span id="tishi"></span>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
