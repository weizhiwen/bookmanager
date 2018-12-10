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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/system/img/icon.ico" />
    <title>长江大学图书管理系统-图书信息维护</title>
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
                    <li><a href="#">图书管理</a></li>
                    <li class="active">图书信息维护</li>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/book_edit.action" method="post" enctype="multipart/form-data">
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="id">图书序号：</label>
                                <input type="number"  id="id" class="form-control" name="bkId" value="${book.bkId}">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="code">索书号：</label>
                                <input type="number"  id="code" class="form-control" name="bkCode" value="${book.bkCode}">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="name">图书名称：</label>
                                <input type="text" id="name" class="form-control"  name="bkName" value="${book.bkName}">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="author">图书作者：</label>
                                <input type="text" id="author" class="form-control"  name="bkAuthor" value="${book.bkAuthor}">
                            </div>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="press">出版社：</label>
                                <input type="text" id="press" class="form-control"  name="bkPress" value="${book.bkPress}">
                            </div>
                            <div class="form-group input-group-sm">
                                <label for="datePress">出版日期：</label>
                                <input type="date" id="datePress" class="form-control" name="bkDatePress" value="<fmt:formatDate value="${book.bkDatePress}" pattern="yyyy-MM-dd"/>">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="catalog">分类号：</label>
                                <input type="text" id="catalog" class="form-control" name="bkCatalog" value="${book.bkCatalog}">
                            </div>
                            <div class="form-group input-group-sm">
                                <label for="isbn">ISBN：</label>
                                <input type="number" id="isbn" class="form-control"  name="bkIsbn" value="${book.bkIsbn}">
                            </div>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="language">语种：</label>
                                <select name="bkLanguage" class="form-control" id="language">
                                    <option value="0" <c:if test="${0 == book.bkLanguage}">selected</c:if>>中文</option>
                                    <option value="1" <c:if test="${1 == book.bkLanguage}">selected</c:if>>英文</option>
                                    <option value="2" <c:if test="${2 == book.bkLanguage}">selected</c:if>>日文</option>
                                    <option value="3" <c:if test="${3 == book.bkLanguage}">selected</c:if>>俄文</option>
                                    <option value="4" <c:if test="${4 == book.bkLanguage}">selected</c:if>>德文</option>
                                    <option value="5" <c:if test="${5 == book.bkLanguage}">selected</c:if>>法文</option>
                                </select>
                            </div>
                            <div class="form-group input-group-sm">
                                <label for="page">图书页数：</label>
                                <input type="number" id="page" class="form-control"  name="bkPages" value="${book.bkPages}">
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <label for="price">图书价格：</label>
                                <input type="text" id="price" class="form-control" name="bkPrice" value="${book.bkPrice}">
                            </div>
                            <div class="form-group input-group-sm">
                                <label for="dateIn">入馆日期：</label>
                                <input type="date" id="dateIn" class="form-control" name="bkDateIn" value="<fmt:formatDate value="${book.bkDateIn}" pattern="yyyy-MM-dd"/>">
                            </div>
                        </div><br />
                        <div class="form-inline">
                            <div class="form-group input-group-sm">
                                <label for="brief">内容简介：</label><br>
                                <textarea name="bkBrief" id="brief" cols="30" rows="10">${book.bkBrief}</textarea>
                                <%--<input type="text" id="brief" class="form-control"  name="bkBrief">--%>
                            </div>&nbsp;
                            <div class="form-group input-group-sm">
                                <img src="${pageContext.request.contextPath}/book_showImg.action?bkId=${book.bkId}" alt="头像">
                                <label for="cover">更改图书封面：</label>
                                <input type="file" id="cover" name="cover">
                            </div>
                            <div class="form-group input-group-sm">
                                <label for="status">图书状态：</label>
                                <select id="status" class="form-control" name="bkStatus">
                                    <option value="在馆" <c:if test="${'在馆'.equals(book.bkStatus)}">selected</c:if>>在馆</option>
                                    <option value="遗失" <c:if test="${'遗失'.equals(book.bkStatus)}">selected</c:if>>遗失</option>
                                    <option value="变卖" <c:if test="${'变卖'.equals(book.bkStatus)}">selected</c:if>>变卖</option>
                                    <option value="销毁" <c:if test="${'销毁'.equals(book.bkStatus)}">selected</c:if>>销毁</option>
                                </select>
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
