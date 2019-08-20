<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/19
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="../css/core.css" />
    <link rel="stylesheet" href="../css/menu.css" />
    <link rel="stylesheet" href="../css/amazeui.css" />
    <link rel="stylesheet" href="../css/component.css" />
    <link rel="stylesheet" href="../css/page/form.css" />
</head>
<body>
<div class="account-pages">
    <div class="wrapper-page">
        <div class="text-center">
            <a href="index.jsp" class="logo"><span>水果<span>烘焙坊</span></span></a>
        </div>

        <div class="m-t-40 card-box">
            <div class="text-center">
                <h4 class="text-uppercase font-bold m-b-0">登陆</h4>
            </div>
            <div class="panel-body">
                <form class="am-form">
                    <div class="am-g">
                        <div class="am-form-group">
                            <input type="email" class="am-radius"  placeholder="用户名">
                        </div>

                        <div class="am-form-group form-horizontal m-t-20">
                            <input type="password" class="am-radius"  placeholder="密码">
                        </div>

                        <div class="am-form-group ">
                            <label style="font-weight: normal;color: #999;">
                                <input type="checkbox" class="remeber"> 记住密码
                            </label>
                        </div>

                        <div class="am-form-group ">
                            <button type="button" class="am-btn am-btn-primary am-radius" style="width: 100%;height: 100%;">登陆</button>
                        </div>

                        <div class="am-form-group ">
                            <a href="page-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i> 忘记密码</a>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>

