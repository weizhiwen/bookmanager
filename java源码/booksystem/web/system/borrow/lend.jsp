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
    <title>长江大学图书管理系统-借阅图书</title>
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
                    <li class="active">借书</li>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/borrow_lend.action" method="post">
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="id">借阅记录号：</label>
                                <input type="text"  id="id" class="form-control" name="brId">
                                <script>
                                    var id = document.getElementById("id");
                                    var date = new Date();
                                    date.setHours(date.getHours() < 10 ? "0" + date.getHours() : date.getHours());
                                    date.setMinutes(date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes());
                                    date.setSeconds(date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds());
                                    id.value = date.getFullYear()+""+(date.getMonth()+1)+""+date.getDate()+""+date.getHours()+""+date.getMinutes()+""+date.getSeconds();
                                </script>
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="userId">借书人编号：</label>
                                <input type="text"  id="userId" class="form-control" name="user.usId">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="name">所借图书编号：</label>
                                <input type="text" id="name" class="form-control"  name="book.bkId">
                            </div>&nbsp;
                            <%--<div class="form-group input-group-sm">
                                <label for="author">续借次数</label>
                                <input type="text" id="author" class="form-control"  name="continueTime">
                            </div>--%>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="dateOut">借出日期：</label>
                                <input type="date" id="dateOut" class="form-control"  name="dateOut">
                                <script>
                                    var dateOut = document.getElementById("dateOut");
                                    var date = new Date();
                                    dateOut.value = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                                </script>
                            </div>
                            <%--<div class="form-group input-group-sm">
                                <label for="dateReturnPlan">理应归还日期：</label>
                                <input type="date" id="dateReturnPlan" class="form-control"  name="dateReturnPlan">
                                <script>
                                    var dateReturnPlan = document.getElementById("dateReturnPlan");
                                    var date = new Date();
                                    dateReturnPlan.value = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                                </script>
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="dateReturnFact">实际归还日期：</label>
                                <input type="date" id="dateReturnFact" class="form-control" name="dateReturnFact">
                                <script>
                                    var dateReturnPlan = document.getElementById("id");
                                    var date = new Date();
                                    dateReturnPlan.value = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                                </script>
                            </div>--%>
                            <%--<div class="form-group input-group-sm">
                                <label for="overDay">逾期天数：</label>
                                <input type="number" id="overDay" class="form-control"  name="overDay" value="0">
                            </div>--%>
                        </div><br />
                        <div class="form-inline">
                            <%--<div class="form-group input-group-sm">
                                <label for="overMoneyPlan">理论罚款：</label>
                                <input type="text" id="overMoneyPlan" class="form-control"  name="overMoneyPlan" value="0">
                            </div>
                            <div class="form-group input-group-sm">
                                <label for="overMoneyFact">实际罚款：</label>
                                <input type="text" id="overMoneyFact" class="form-control"  name="overMoneyFact" value="0">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="hasReturn">是否归还：</label>
                                <input type="text" id="hasReturn" class="form-control" name="hasReturn" value="否">
                            </div>--%>
                            <div class="form-group input-group-sm">
                                <label for="dateIn">借出操作员：</label>
                                <input type="text" id="dateIn" class="form-control" name="operatorLend" value="${loginUser.usName}">
                            </div>
                            <%--<div class="form-group input-group-sm">
                                <label for="operatorReturn">归还操作员：</label>
                                <input type="text" id="operatorReturn" class="form-control" name="operatorReturn">
                            </div>--%>
                        </div><br />
                        <p class="errormsg">${errormsg}</p>
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
