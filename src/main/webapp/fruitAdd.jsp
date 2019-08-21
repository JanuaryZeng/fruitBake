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

<div class="content-page">
    <!-- Start content -->
    <div class="content">
        <div class="am-g">
            <!-- Row start -->
            <div class="am-u-sm-12">
                <div class="card-box">
                    <form:form action="add" class="am-form" modelAttribute="fruitAdd">
                        <fieldset>
                            <legend> 表单验证</legend>
                            <div class="am-form-group">
                                <label for="fname">水果名：</label>
                                <form:input path="fname" placeholder="不能为空"/>
                            </div>

                            <div class="am-form-group">
                                <label for="mean">控制流程：</label>
                                <form:input path="mean" placeholder="不能为空" />
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

