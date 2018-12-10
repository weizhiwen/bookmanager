<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2017/12/19
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/system/img/icon.ico" />
    <title>长江大学图书管理系统-续借图书</title>
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
                    <li><a href="#">借阅管理</a></li>
                    <li class="active">续借图书</li>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/borrow_userCondition.action" method="get">
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="custName">读者编号：</label>
                                <input type="text" id="custName" class="form-control" name="user.usId" placeholder="输入借书人的编号">
                                <input type="submit" class="btn btn-primary btn-sm" value="筛选"/>
                            </div>
                        </div><br>
                    </form>
                    <p class="errormsg">${errormsg}</p>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr class="bg-info">
                                <th>借阅号</th>
                                <th>借书人</th>
                                <th>图书名</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${borrowList}" var="borrow">
                                <tr>
                                    <td>${borrow.brId}</td>
                                    <td>${borrow.user.usName}</td>
                                    <td>${borrow.book.bkName}</td>
                                    <td><a href="${pageContext.request.contextPath}/borrow_continueLend.action?brId=${borrow.brId}">续借</a> <a href="${pageContext.request.contextPath}/borrow_toReturnBookPage.action?brId=${borrow.brId}">还书</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
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