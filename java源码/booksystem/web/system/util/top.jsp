<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2017/12/12
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<div class="head">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a href="javascrpt:;" class="navbar-brand navbar-title">长江大学图书管理系统</a>
            </div>
            <div class="nav navbar-nav navbar-right">
                <li class="navbar-text">当前用户：${loginUser.usName}</li>
                <%--<a href="" class="navbar-text navbar-link" style="color: crimson;">修改密码</a>--%>
                <a href="${pageContext.request.contextPath}/user_loginOut.action" class="navbar-text navbar-link" style="color: crimson;">安全退出</a>
            </div>
        </div>
    </nav>
</div>

