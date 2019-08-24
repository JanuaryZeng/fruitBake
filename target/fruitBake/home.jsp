<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/23
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.jsp" class="logo"><span>水果<span>烘焙坊</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">首页</h4></li>
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
            <div class="am-u-md-6" >
                <!-- 折线图堆叠 -->
                <div class="card-box">
                    <div  id="pie1" style="width: 100%;height: 400px;"></div>
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
<script type="text/javascript" src="../js/charts/echarts.min.js" ></script>

<script src="../js/jquery-2.1.0.js">
</script>
<script>


    (function(){

        var pie1 = echarts.init(document.getElementById("pie1"));

        option = {
            title : {
                text: '烤制水果数量饼图',
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
