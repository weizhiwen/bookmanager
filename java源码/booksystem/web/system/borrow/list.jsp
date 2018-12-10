<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2017/12/12
  Time: 22:58
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
    <title>长江大学图书管理系统-查看借阅</title>
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
                    <li class="active">查看借阅</li>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr class="bg-info">
                                <th>借书记录号</th>
                                <th>读者编号</th>
                                <th>读者姓名</th>
                                <th>图书编号</th>
                                <th>图书书名</th>
                                <th>续借次数</th>
                                <th>借出时间</th>
                                <th>最迟归还时间</th>
                                <th>实际归还时间</th>
                                <th>逾期天数</th>
                                <th>逾期罚款钱数</th>
                                <th>实际罚款天数</th>
                                <th>是否归还</th>
                                <th>借书操作员</th>
                                <th>还书操作员</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${borrowList}" var="borrow">
                                <tr>
                                    <td>${borrow.brId}</td>
                                    <td>${borrow.user.usId}</td>
                                    <td>${borrow.user.usName}</td>
                                    <td>${borrow.book.bkId}</td>
                                    <td>${borrow.book.bkName}</td>
                                    <td>${borrow.continueTime}</td>
                                    <td>${borrow.dateOut}</td>
                                    <td>${borrow.dateReturnPlan}</td>
                                    <td><fmt:formatDate value="${borrow.dateReturnFact}" pattern="yyyy-MM-dd"/></td>
                                    <td>${borrow.overDay}</td>
                                    <td>${borrow.overMoneyPlan}</td>
                                    <td>${borrow.overMoneyFact}</td>
                                    <td>${borrow.hasReturn}</td>
                                    <td>${borrow.operatorLend}</td>
                                    <td>${borrow.operatorReturn}</td>
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
