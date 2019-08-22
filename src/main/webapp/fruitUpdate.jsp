<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/21
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="top.jsp"/>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.jsp" class="logo"><span>水果<span>烘焙坊</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">水果表单</h4></li>
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
    <!-- Start content -->
    <div class="content">
        <div class="am-g">
            <!-- Row start -->
            <div class="am-u-sm-12">
                <div class="card-box">
                    <form:form action="update" class="am-form" modelAttribute="toUpdate">
                        <fieldset>
                            <legend> 修改水果表单</legend>
                            <div class="am-form-group">
                                <label for="fname">水果名：</label>
                                <form:input path="fname" placeholder="不能为空" readonly="true"/>
                            </div>

                            <div class="am-form-group">
                                <label for="mean">控制流程：</label>
                                <form:input path="mean" placeholder="不能为空" />
                            </div>
                            <div class="am-form-group">
                                <label for="mean">头像地址：</label>
                                <form:input path="ficon" placeholder="不能为空" />
                            </div>
                            <button class="am-btn am-btn-secondary" type="submit">提交</button>
                            <button class="am-btn am-btn-secondary" type="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </fieldset>
                    </form:form>


                </div>
            </div>
            <!-- Row end -->
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

