<%@ page import="com.etc.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/21
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //获取Login.html提交来的信息
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String type = request.getParameter("type");
    //检查用户登录是否成功,这里假设用户名密码均为为admin就表示登录成功，

    //将用户信息写入session对象
//    session.setAttribute("name", name);
//    session.setAttribute("password", password);
    session.setAttribute("type", type);
    ///根据用户选择的权限类型跳转页面，
    if (type.equals("admin")) {
        //将用户信息写入session对象
        session.setAttribute("adminname", name);
        session.setAttribute("password", password);
        response.sendRedirect(response.encodeURL("/jiajiaoProject/doAdminLogin"));
    }else if (type.equals("teacher")) {
        //将用户信息写入session对象
        session.setAttribute("teaname", name);
        session.setAttribute("password", password);
        response.sendRedirect(response.encodeURL("/jiajiaoProject/doLogin"));
    }else if (type.equals("parents")) {
        //将用户信息写入session对象
        session.setAttribute("parentname", name);
        session.setAttribute("password", password);
        response.sendRedirect(response.encodeURL("/jiajiaoProject/doStudentLogin"));
    }else {
        out.print("<script language='JavaScript' type='text/JavaScript'>alert('异常！请重新登录！');</script>");
        response.sendRedirect("/jiajiaoProject/LOGIN/login");
    }

//
//    if (name.equals("admin") && password.equals("admin")) {
//   //     验证码验证
//        String input = request.getParameter("yanzhengma");
//        String code = (String) session.getAttribute("code");
//        if (input.equals(code)) {
//            out.print("<script>alert('验证成功！');</script>");
//            ///验证通过后，将用户信息写入session对象，
//        session.setAttribute("name", name);
//        session.setAttribute("password", password);
//        session.setAttribute("type", type);
//        ///根据用户选择的权限类型跳转页面，
//        if (type.equals("admin"))
//            response.sendRedirect("admin.jsp");
//        else if (type.equals("teacher"))
//            response.sendRedirect(response.encodeURL("/jiajiaoProject/LOGIN/teacher"));
//        else if (type.equals("parents"))
//            response.sendRedirect("/jiajiaoProject/LOGIN/parents");
//        else {
//            out.print("<script language='JavaScript' type='text/JavaScript'>alert('异常！请重新登录！');</script>");
//            response.sendRedirect(response.encodeURL("/jiajiaoProject/LOGIN/login"));
//        }
//    }
//    else {
//            out.print("<script>alert('验证失败！');window.location.href='Login.jsp';</script>");
//        }
//    }
//    else
//    //登录失败，回到Login.jsp页面。
//    {
//        out.print("<script>alert('请正确填写信息！');window.location.href='/jiajiaoProject/LOGIN/login'</script>");
//    }
%>

<html>
<head>
    <title>登录验证</title>
</head>
<body>

</body>
</html>