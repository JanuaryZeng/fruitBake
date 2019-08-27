<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/21
  Time: 16:14
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

            <li><h4 class="page-title">烤箱表单</h4></li>
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
                    <form:form action="add" class="am-form" modelAttribute="OvensAdd">
                        <fieldset>
                            <legend> 添加烤箱表单</legend>

                            <div class="am-form-group">
                                <label for="oname">烤箱名：</label>
                                <form:input path="oname" placeholder="不能为空" />
                            </div>
                            <div class="am-form-group">
                                <label for="ostatus">当前状态：</label>
                                <form:input path="ostatus" placeholder="不能为空" />
                            </div>
                            <div class="am-form-group">
                                <label for="IP">烤箱地址：</label>
                                <form:input path="IP" placeholder="不能为空" />
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

