<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2017/12/12
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="panel-group panel-primary">
    <div class="panel-heading">
        <h3 id="accordion" class="panel-title">系统功能菜单</h3>
    </div>
    <div class="panel-body bg-info">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" data-parent="#accordion" data-toggle="collapse" data-target="#list0"><a href="javascript:0;">个人中心</a></h3>
            </div>
            <div id="list0" class="collapse">
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/user_toInfoPage.action">个人信息</a><br />
                    <%--<a href="${pageContext.request.contextPath}/user_toChangePassword.action">修改密码</a><br />--%>
                </div>
            </div>
        </div>
        <c:if test="${loginUser.adRole.adRoleId == 1 || loginUser.adRole.adRoleId == 4}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" data-parent="#accordion" data-toggle="collapse" data-target="#list1"><a href="javascript:0;">读者管理</a></h3>
            </div>
            <div id="list1" class="collapse">
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/user_toAddPage.action">办理借书证</a><br />
                    <a href="${pageContext.request.contextPath}/user_list.action">借书证信息变更</a><br />
                    <%--<a href="${pageContext.request.contextPath}/customer_listPage.action?currentPage=1">借书证挂失与解除</a><br />
                    <a href="${pageContext.request.contextPath}/customer_listPage.action?currentPage=1">注销借书证</a><br />--%>
                    <a href="${pageContext.request.contextPath}/rdType_toAddPage.action">添加读者类型</a><br />
                    <a href="${pageContext.request.contextPath}/rdType_list.action">读者类型管理</a>
                </div>
            </div>
        </div>
        </c:if>
        <c:if test="${loginUser.adRole.adRoleId == 2|| loginUser.adRole.adRoleId == 4}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" data-parent="#accordion" data-toggle="collapse" data-target="#list2"><a href="javascript:0;">图书管理</a></h3>
            </div>
            <div id="list2" class="collapse">
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/book_toAddPage.action">新书入库</a><br />
                    <a href="${pageContext.request.contextPath}/book_list.action">图书信息维护</a>
                </div>
            </div>
        </div>
        </c:if>
        <c:if test="${loginUser.adRole.adRoleId == 3 || loginUser.adRole.adRoleId == 4}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" data-parent="#accordion" data-toggle="collapse" data-target="#list3"><a href="javascript:0;">借阅管理</a></h3>
            </div>
            <div id="list3" class="collapse">
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/borrow_toLendPage.action">借书</a><br />
                    <a href="${pageContext.request.contextPath}/borrow_continueAndReturn.action">续借和还书</a><br />
                    <a href="${pageContext.request.contextPath}/borrow_list.action">查看借阅</a>
                </div>
            </div>
        </div>
        </c:if>
        <c:if test="${loginUser.adRole.adRoleId == 4}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" data-parent="#accordion" data-toggle="collapse" data-target="#list4"><a href="javascript:0;">用户管理</a></h3>
            </div>
            <div id="list4" class="collapse">
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/user_toAddAdminPage.action">新增管理</a><br />
                    <a href="${pageContext.request.contextPath}/user_listAdmin.action">查看管理</a><br />
                </div>
            </div>
        </div>
        </c:if>
    </div>
</div>
