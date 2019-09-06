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

            <li><h4 class="page-title">折线图</h4></li>
        </ul>
    </div>
</header>
<br/>
<br/>

<div class="content-page">
    <!-- Start content -->
    <div class="content">

        <div class="am-g">
            <div class="am-u-md-12">
                <div class="card-box">
                    <div  id="trends" style="width: 100%;height: 300px;"></div>
                </div>
            </div>
        </div>
        <div class="am-g">
            <div class="am-u-md-12">
                <div class="card-box">
                    <div  id="trends1" style="width: 100%;height: 300px;"></div>
                </div>
            </div>
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
<c:forEach items="${noteId}" var="dept" varStatus="status">

<script>

    //动态数据+时间坐标轴
    (function(){

        var trends = echarts.init(document.getElementById("trends"));

        function createData(num,time) {
            Ltime = new Date(time.toString());
            return{
                name: Ltime.toString(),
                value: [
                    Ltime.toString(),
                    num
                ]
            }
        }
        noteid = ${dept}

        option = {
            title: {
                text: '动态数据 + 时间坐标轴'
            },
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    params = params[0];
                    var date = new Date(params.name);
                    return date.getFullYear() + '/' + (date.getMonth() + 1) + '/' + date.getDate() + ' '
                        + date.getHours() + ":" + date.getMinutes() + ":"
                        + date.getSeconds() + " | " + params.value[1];
                },
                axisPointer: {
                    animation: false
                }
            },
            xAxis: {
                type: 'time',
                splitLine: {
                    show: false
                }
            },
            yAxis: {
                type: 'value',
                boundaryGap: [0, '100%'],
                splitLine: {
                    show: false
                }
            },
            series: [{
                name: '模拟数据',
                type: 'line',
                showSymbol: false,
                hoverAnimation: false,
                data: []
            }]
        };
        trends.setOption(option);


        <%--var state = ${noteId};--%>
        $.ajax({
            type: "post",
            url: "/fruitBake_war_exploded/logs/findByNoteId",
            data : {"noteId":noteid},
            cache : false,    //禁用缓存
            dataType: "json",
            success: function(result) {
                var datas=[];//定义两个数组

                $.each(result['findByNoteId'],function(key,values){ //此处我返回的是list<String,map<String,String>>循环map
                    datas.push(createData(values['humi'],values['ltime']))
                });

                trends.setOption({ //加载数据图表
                    title:{
                        text: "记录ID为："+noteid+" 的湿度数据变化情况"
                    },
                    series: {
                        data: datas
                    }
                });
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("查询失败");
            }
        });

        timeTicket = setInterval(function () {

            $.ajax({
                type: "post",
                url: "/fruitBake_war_exploded/logs/findByNoteId",
                data : {"noteId":noteid},
                cache : false,    //禁用缓存
                dataType: "json",
                success: function(result) {
                    var datas=[];//定义两个数组
                    $.each(result['findByNoteId'],function(key,values){ //此处我返回的是list<String,map<String,String>>循环map
                        datas.push(createData(values['humi'],values['ltime']))
                    });

                    trends.setOption({ //加载数据图表
                        // title:{
                        //     text: "编号为"+state
                        // },
                        series: {
                            data: datas
                        }
                    });
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("查询失败");
                }
            });
        }, 1000);

    })();

</script>
    <script>

        //动态数据+时间坐标轴
        (function(){

            var trends1 = echarts.init(document.getElementById("trends1"));

            function createData(num,time) {
                Ltime = new Date(time.toString());
                return{
                    name: Ltime.toString(),
                    value: [
                        Ltime.toString(),
                        num
                    ]
                }
            }
            noteid = ${dept}

                option = {
                    title: {
                        text: '动态数据 + 时间坐标轴'
                    },
                    tooltip: {
                        trigger: 'axis',
                        formatter: function (params) {
                            params = params[0];
                            var date = new Date(params.name);
                            return date.getFullYear() + '/' + (date.getMonth() + 1) + '/' + date.getDate() + ' '
                                + date.getHours() + ":" + date.getMinutes() + ":"
                                + date.getSeconds() + " | " + params.value[1];
                        },
                        axisPointer: {
                            animation: false
                        }
                    },
                    xAxis: {
                        type: 'time',
                        splitLine: {
                            show: false
                        }
                    },
                    yAxis: {
                        type: 'value',
                        boundaryGap: [0, '100%'],
                        splitLine: {
                            show: false
                        }
                    },
                    series: [{
                        name: '模拟数据',
                        type: 'line',
                        showSymbol: false,
                        hoverAnimation: false,
                        data: []
                    }]
                };
            trends1.setOption(option);


            <%--var state = ${noteId};--%>
            $.ajax({
                type: "post",
                url: "/fruitBake_war_exploded/logs/findByNoteId",
                data : {"noteId":noteid},
                cache : false,    //禁用缓存
                dataType: "json",
                success: function(result) {
                    var datas=[];//定义两个数组

                    $.each(result['findByNoteId'],function(key,values){ //此处我返回的是list<String,map<String,String>>循环map
                        datas.push(createData(values['temp'],values['ltime']))
                    });
                    trends1.setOption({ //加载数据图表
                        title:{
                            text: "记录ID为："+noteid+" 的温度数据变化情况"
                        },
                        series: {
                            data: datas
                        }
                    });
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("查询失败");
                }
            });

            timeTicket = setInterval(function () {

                $.ajax({
                    type: "post",
                    url: "/fruitBake_war_exploded/logs/findByNoteId",
                    data : {"noteId":noteid},
                    cache : false,    //禁用缓存
                    dataType: "json",
                    success: function(result) {
                        var datas=[];//定义两个数组

                        $.each(result['findByNoteId'],function(key,values){ //此处我返回的是list<String,map<String,String>>循环map
                            datas.push(createData(values['temp'],values['ltime']))
                        });

                        trends1.setOption({ //加载数据图表
                            // title:{
                            //     text: "编号为"+state
                            // },
                            series: {
                                data: datas
                            }
                        });
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert("查询失败");
                    }
                });
            }, 1000);

        })();

    </script>
</c:forEach>

</body>

</html>