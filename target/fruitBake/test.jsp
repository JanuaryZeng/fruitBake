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
            url: "../notes/fruitCount",
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
