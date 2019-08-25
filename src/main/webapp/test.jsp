<%--
  Created by IntelliJ IDEA.
  User: January
  Date: 2019/8/23
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/amazeui.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/core.css" />
    <link rel="stylesheet" href="css/menu.css" />
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/admin.css" />
    <link rel="stylesheet" href="css/page/typography.css" />
    <script src="js/jquery-2.1.0.js">
    </script>
    <script>
        $(document).ready(function(){
            $("p").click(function(){
                $(this).hide();
            });
        });
    </script>
</head>
<body>
<p>如果您点击我，我会消失。</p>
<p>点击我，我会消失。</p>
<p>也要点击我哦。</p>
<p id="testID"></p>

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

<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>
<script type="text/javascript" src="js/app.js" ></script>
<script type="text/javascript" src="js/blockUI.js" ></script>
<script type="text/javascript" src="js/charts/echarts.min.js" ></script>

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
            url: "notes/fruitCount",
            // data : {"year":year,"mouth":mouth},
            cache : false,    //禁用缓存
            dataType: "json",
            success: function(result) {
                var names=[];//定义两个数组
                var nums=[];
                // console.warn(result['count']);

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
