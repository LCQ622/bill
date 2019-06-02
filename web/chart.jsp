<%--
  Created by IntelliJ IDEA.
  User: XiaoXin-700
  Date: 2018/12/16
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图表</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/highcharts.js"></script>
    <script>
        $(function () {
            $.post("chart_data", function (data) {
                var dates = new Array();
                var moneys = new Array();
                for (var i = 0; i < data.length; i++) {
                    dates[i] = data[i].date;
                    moneys[i] = data[i].sum;
                }

                obj = {
                    /*chart: {
                        //设置为 柱状图
                        type: "column"
                    },*/
                    title: {
                        //设置标题
                        text: "消费金额统计"
                    },
                    subtitle: {
                        //设置副标题
                        text: "数据来源：bill 数据库"
                    },
                    xAxis: {
                        //设置x 轴
                        categories: dates
                    },
                    yAxis: {
                        //设置y 轴
                        min: 0, //设置y 轴的最小值为0
                        title: {
                            //设置y 轴的 标题
                            text: "消费金额"
                        }
                    },
                    //设置数据
                    series: [{
                        name: "消费金额",
                        data: moneys
                    }],
                    credits: {
                        //禁用 版权logo
                        enabled: false
                    }
                };


                $("#com").highcharts(obj);
            });


            $.post("chart_pay_mode_sum", function (data) {

                var pay_modes = new Array();
                var moneys = new Array();

                for (var i = 0; i < data.length; i++) {
                    pay_modes[i] = data[i].pay_mode;
                    moneys[i] = data[i].sum;
                }


                var obj = {
                    chart: {
                        //设置为 柱状图
                        type: "column"
                    },
                    title: {
                        //设置标题
                        text: "本月各个支付方式消费金额统计"
                    },
                    subtitle: {
                        //设置副标题
                        text: "数据来源：bill 数据库"
                    },
                    xAxis: {
                        //设置x 轴
                        categories: pay_modes
                    },
                    yAxis: {
                        //设置y 轴
                        min: 0, //设置y 轴的最小值为0
                        title: {
                            //设置y 轴的 标题
                            text: "消费金额"
                        }
                    },
                    //设置数据
                    series: [{
                        name: "消费金额",
                        data: moneys
                    }],
                    credits: {
                        //禁用 版权logo
                        enabled: false
                    }
                };
                $("#pay_mode_sum").highcharts(obj);

            });


            $.post("chart_pay_mode_count",function (data) {

                var pay_modes = new Array();
                var counts = new Array();

                for (var i = 0; i < data.length; i++) {
                    pay_modes[i]=data[i].pay_mode;
                    counts[i]=data[i].count;
                }

                var obj = {
                    chart: {
                        type: "pie"
                    },
                    title:{
                        text:"本月支付方式占比"
                    },
                    subtitle:{
                        text:"数据来源：bill 数据库"
                    },
                    series:[{
                        name:"支付笔数",
                        data:[
                            [pay_modes[0],counts[0]],
                            [pay_modes[1],counts[1]],
                            [pay_modes[2],counts[2]],
                            [pay_modes[3],counts[3]]
                        ]
                    }],

                    credits:{
                        enabled: false
                    }
                };
                $("#pay_mode_count").highcharts(obj);

            });


        });

    </script>
<style>
    #com{
        max-width: 600px;
        max-height: 400px;
        float: left;
    }
    #pay_mode_sum{
        max-width: 600px ;
        max-height: 400px;
        float: left;
    }
    #pay_mode_count{
        max-width: 600px ;
        max-height: 400px;
        float: left;
    }
</style>
</head>
<body>
<div id="com" ></div>
<br>
<div id="pay_mode_sum" ></div>
<br>
<div id="pay_mode_count"></div>
</body>
</html>
