<%--
  Created by IntelliJ IDEA.
  User: ruige
  Date: 2018/10/7
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>教师信息</title>
    <script src="js/echarts.js" type="text/javascript" charset="utf-8"></script>
</head>

<body style="background-image: linear-gradient(to top, #FFEBCD 0%, #d1fdff 100%);">
<div id="chart" style="width: 50%;height: 630px;float: left;"></div>
<div id="chart1" style="width: 50%;height: 630px;float: right;"></div>
<script type="text/javascript">
    var colors = ['#7FFFD4', '#87CEFF', '#63B8FF', '#90EE90', '#EEE685', '#FFA07A'];
    var myChart = echarts.init(document.getElementById('chart'));
    var myChart1 = echarts.init(document.getElementById('chart1'));
    var value1 = 10;
    var option = {
        color: colors,

        title: {
            text: '各个科目老师人数',
            subtext: '',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['语文老师', '数学老师', '英语老师', '物理老师', '化学老师', '生物老师']
        },
        series: [{
            name: '大学生家教',
            type: 'pie',
            selectedMode: 'single',
            radius: '55%',
            center: ['50%', '50%'],
            data: [{
                value: ${education.chinese},
                name: '语文老师'
            },
                {
                    value: ${education.math},
                    name: '数学老师'
                },
                {
                    value: ${education.english},
                    name: '英语老师'
                },
                {
                    value: ${education.physics},
                    name: '物理老师'
                },
                {
                    value: ${education.chemistry},
                    name: '化学老师'
                },
                {
                    value: ${education.biology},
                    name: '生物老师'
                }
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    myChart.setOption(option);
    var options = {
        color: colors,

        title: {
            text: '各个年级老师比例',
            subtext: '',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'right',
            data: ['高中老师', '初中老师', '小学老师']
        },
        series: [{
            name: '大学生家教',
            type: 'pie',
            selectedMode: 'single',
            radius: '55%',
            center: ['50%', '50%'],
            data: [{
                value: ${education.high},
                name: '高中老师',
            },
                {
                    value: ${education.middle},
                    name: '初中老师',
                },
                {
                    value: ${education.primary},
                    name: '小学老师'
                }
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    myChart1.setOption(options);
</script>
</body>

</html>
