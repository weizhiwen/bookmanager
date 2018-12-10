<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2017/12/12
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/system/img/icon.ico" />
    <title>长江大学图书管理系统-办理借阅证</title>
    <link href="${pageContext.request.contextPath}/system/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/7.0.0/normalize.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/system/css/main.css" />
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container-fluid bg">
    <!--页面头部开始-->
    <jsp:include page="../util/top.jsp"></jsp:include>
    <!--页面头部结束-->

    <!--页面主体开始-->
    <div class="main">
        <div class="main-left col-lg-2 col-md-2 col-sm-3">
            <!--导航菜单开始-->
            <%@ include file="../util/menu.jsp"%>
            <!--导航菜单结束-->
        </div>
        <div class="main-right col-lg-10 col-md-10 col-sm-9">
            <div class="row">
                <ul class="breadcrumb">
                    <span>当前位置：</span>
                    <li><a href="#">读者管理</a></li>
                    <li class="active">办理借书证</li>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/user_add.action" method="post" enctype="multipart/form-data">
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="id">借书证号：</label>
                                <input type="text"  id="id" class="form-control" name="usId">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="name">姓名：</label>
                                <input type="text"  id="name" class="form-control" name="usName">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="password">密码：</label>
                                <input type="text" id="password" class="form-control"  name="usPassword" value="123">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="sex">性别：</label>
                                <select id="sex" name="usSex">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="type">读者类型：</label>
                                <select id="type" name="rdType.rdTypeId">
                                    <c:forEach items="${rdTypeList}" var="rdType">
                                        <option value="${rdType.rdTypeId}">${rdType.rdTypeName}</option>
                                    </c:forEach>
                                </select>
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="department">单位：</label>
                                <input type="text" id="department" class="form-control" name="usDepartment">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="phone">电话：</label>
                                <input type="tel" id="phone" class="form-control" name="usPhone">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="email">邮箱：</label>
                                <input type="email" id="email" class="form-control" name="usEmail">
                            </div>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="date">注册日期：</label>
                                <input type="date" id="date" class="form-control" name="usDateRegister">
                                <script>
                                    var date = document.getElementById("date");
                                    date.value = (new Date().getFullYear())+"-"+(new Date().getMonth()+1)+"-"+(new Date().getDate());
                                </script>
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="count">已借书：</label>
                                <input type="number" id="count" class="form-control"  name="usBorrowCount" value="0">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="status">证件状态：</label>
                                <select id="status" name="usStatus">
                                    <option value="有效">有效</option>
                                    <option value="挂失">挂失</option>
                                    <option value="注销">注销</option>
                                </select>
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="role">管理角色：</label>
                                <select id="role" name="adRole.adRoleId">
                                    <c:forEach items="${adRoleList}" var="adRole">
                                        <option value="${adRole.adRoleId}">${adRole.adRoleName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="img">上传图片<small> (图片大小限制为 64k)</small></label>
                                <input type="file" id="img" name="photo">
                            </div>
                        </div><br />
                        <input type="submit" class="btn btn-primary" value="保存"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--页面主体结束-->

    <!--页面底部开始-->
    <div class="foot col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <hr />
        <p class="text-center">&copy; 版权所有：长江大学图书馆&nbsp;&nbsp;&nbsp;技术支持：魏志文</p>
    </div>
    <!--页面底部内容结束-->
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/system/js/bootstrap.min.js"></script>
</body>
</html>
