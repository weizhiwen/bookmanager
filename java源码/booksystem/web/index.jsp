<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2017/12/15
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/system/img/icon.ico" />
  <title>长江大学图书管理系统-登录</title>
  <link href="${pageContext.request.contextPath}/system/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/7.0.0/normalize.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/system/css/main.css" />
  <!--[if lt IE 9]>
  <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container-fluid login">
  <form class="form-login" action="${pageContext.request.contextPath}/user_login.action" method="post">
    <h2 class="login-title">长江大学图书管理系统</h2>
    <div class="form-group">
      <div class="input-group input-group-lg">
        <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
        <input type="text" name="usId" class="form-control" value="" placeholder="请输入用户编号" required/>
      </div>
      <div class="input-group input-group-lg">
        <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
        <input type="password" name="usPassword" class="form-control input-lg" value="" placeholder="请输入密码" required/>
      </div>
      <p class="errormsg">${errormsg}</p>
      <input type="submit" class="btn btn-lg btn-primary btn-block" value="登 录"/>
    </div>
  </form>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/system/js/bootstrap.min.js"></script>
</body>
</html>