<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/23
  Time: 21:29
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

            <li><h4 class="page-title">首页</h4></li>
        </ul>
    </div>
</header>
<br/>
<br/>

<div class="content-page">
    <!-- Start content -->
    <div class="content">
        <div class="am-g">
            <div class="am-u-md-7" >
                <!-- 折线图堆叠 -->
                <div class="card-box">
                    <div  id="pie1" style="width: 100%;height: 400px;"></div>
                </div>
            </div>
            <div class="am-u-md-4">
                <div class="card-box">
                    <h4 class="header-title m-t-0 m-b-30">正在烤制</h4>
                    <div class="inbox-widget nicescroll" style="height: 315px; overflow: hidden; outline: none;" tabindex="5000">
                        <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">

                        <c:forEach items="${work}" var="dept" varStatus="status">
                        <a href="lineChart?noteId=${dept.noteId}">
                            <div class="inbox-item">
                                <div class="inbox-item-img"><img src="../img/avatar-1.jpg" class="img-circle" alt=""></div>
                                <p class="inbox-item-author">${dept.oname}</p>
                                <p class="inbox-item-text">用户名${dept.uname}</p>
                                <p class="inbox-item-date">开始时间${dept.startTime}</p>
                            </div>
                        </a>
                        </c:forEach>
                    </div>
                    </div>
                </div>
            </div>
        </div>

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
                                                <a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="lineChart?noteId=${dept.noteId}"><span class="am-icon-pencil-square-o"></span> 跳转</a>
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

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="../js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="../js/amazeui.min.js"></script>
<script type="text/javascript" src="../js/app.js" ></script>
<script type="text/javascript" src="../js/blockUI.js" ></script>
<script type="text/javascript" src="../js/charts/echarts.min.js" />
<script src="../js/jquery-2.1.0.js">
</script>
<script>


    (function(){

        var pie1 = echarts.init(document.getElementById("pie1"));

        option = {
            title : {
                text: '烤制水果次数饼图',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: []
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'left',
                                max: 1548
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name: '',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        pie1.setOption(option);

        $.ajax({
            type: "get",
            url: "/fruitBake_war_exploded/notes/fruitCount",
            // data : {"year":year,"mouth":mouth},
            cache : false,    //禁用缓存
            dataType: "json",
            success: function(result) {
                var names=[];//定义两个数组
                var nums=[];
                console.warn(result['count']);

                $.each(result['count'],function(key,values){ //此处我返回的是list<String,map<String,String>>循环map
                    var obj = new Object();
                    names.push(values['fname'])

                    obj.name = values['fname'];
                    obj.value = values['num'];
                    nums.push(obj);
                });
                pie1.setOption({ //加载数据图表
                    legend: {
                        data: names
                    },
                    series: {
                        // 根据名字对应到相应的系列
                        name: ['烤制数量'],
                        data: nums
                    }
                });
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("查询失败");
            }
        });
    })();
</script>
</body>

</html>