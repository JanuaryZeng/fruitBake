<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/20
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="top.jsp"/>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.jsp" class="logo"><span>水果<span>烘焙坊</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">烤制记录表单</h4></li>
        </ul>

        <ul class="am-nav am-navbar-nav am-navbar-right">
            <li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
            <li class="hidden-xs am-hide-sm-only">
                <form role="search" class="app-search">
                    <input type="text" placeholder="Search..." class="form-control">
                    <a href=""><img src="../img/search.png"></a>
                </form>
            </li>
        </ul>
    </div>
</header>
<div class="content-page">
    <br>
    <br>
    <!-- Start content -->
    <div class="content">
        <div class="card-box">
            <!-- Row start -->
            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-3">
                    <div class="am-input-group am-input-group-sm">
                        <form action="findOne" >
                            <input type="text" class="am-form-field" name="NoteId">
                            <span class="am-input-group-btn">
				            <button type="submit" class="am-btn am-btn-default">搜索</button>
				            </span>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Row end -->

            <!-- Row start -->
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-id">ID</th><th class="table-title">烤箱名</th><th class="table-title">水果名</th><th class="table-type">开始时间</th><th class="table-author am-hide-sm-only">结束时间</th><th class="table-date am-hide-sm-only">用户名</th><th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${notes}" var="dept" varStatus="status">
                                <tr>
                                    <td>${dept.noteId}</td>
                                    <td>${dept.oname}</td>
                                    <td>${dept.fname}</td>
                                    <td>${dept.startTime}</td>
                                    <td>${dept.endTime}</td>
                                    <td>${dept.uname}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" href="delete?NoteId=${dept.noteId}"><span class="am-icon-trash-o"></span>删除</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <hr />
                    </form>
                </div>

            </div>
            <!-- Row end -->

        </div>




    </div>


</div>
</div>
<!-- end right Content here -->
<!--</div>-->
</div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="../js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="../js/amazeui.min.js"></script>
<script type="text/javascript" src="../js/app.js" ></script>
<script type="text/javascript" src="../js/blockUI.js" ></script>
</body>

</html>

