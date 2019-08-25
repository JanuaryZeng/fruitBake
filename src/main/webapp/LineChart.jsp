<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/23
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<jsp:include page="top.jsp"/>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.jsp" class="logo"><span>水果<span>烘焙坊</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">折线图</h4></li>
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
<br/>
<br/>
<div class="content-page">
    <!-- Start content -->
    <div class="content">

        <div class="am-g">
            <div class="am-u-md-12">
                <!-- 动态数据+时间坐标轴 -->
                <div class="card-box">
                    <div  id="trends" style="width: 100%;height: 300px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>
<script type="text/javascript" src="js/app.js" ></script>
<script type="text/javascript" src="js/blockUI.js" ></script>
<script type="text/javascript" src="js/charts/echarts.min.js" />
<script src="js/jquery-2.1.0.js">
</script>
<script>

    //动态数据+时间坐标轴
    (function(){

        var trends = echarts.init(document.getElementById("trends"));

        function randomData() {
            now = new Date(+now + oneDay);
            value = value + Math.random() * 21 - 10;
            return {
                name: now.toString(),
                value: [
                    [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
                    Math.round(value)
                ]
            }
        }

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

        var data = [];
        var now = +new Date(1997, 9, 3);
        var oneDay = 24 * 3600 * 1000;
        var value = Math.random() * 1000;
        for (var i = 0; i < 1000; i++) {
            data.push(randomData());
        }

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
            url: "logs/findByNoteId",
            data : {"noteId":"2"},
            cache : false,    //禁用缓存
            dataType: "json",
            success: function(result) {
                var datas=[];//定义两个数组
                console.warn(result['findByNoteId']);

                $.each(result['findByNoteId'],function(key,values){ //此处我返回的是list<String,map<String,String>>循环map
                    datas.push(createData(values['humi'],values['ltime']))
                });
                console.warn(datas);

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
        //
        // timeTicket = setInterval(function () {
        //
        //     for (var i = 0; i < 5; i++) {
        //         data.shift();
        //         data.push(randomData());
        //     }
        //
        //     trends.setOption({
        //         series: [{
        //             data: data
        //         }]
        //     });
        // }, 1000);

    })();

</script>
</body>

</html>