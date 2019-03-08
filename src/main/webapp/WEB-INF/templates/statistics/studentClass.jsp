<%--
  Created by IntelliJ IDEA.
  User: ruige
  Date: 2018/10/6
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>学生信息</title>
    <script src="js/echarts.js" type="text/javascript" charset="utf-8"></script>
</head>

<body style="background-image: linear-gradient(to top, #FFEBCD 0%, #d1fdff 100%);">
<div id="chart" style="width: 50%;height: 580px;float: left;"></div>
<div id="chart1" style="width: 50%;height: 630px;float: right;"></div>
<script type="text/javascript">
    var colors = ['#00BFFF', '#FFA07A', '#675bba'];
    var myChart = echarts.init(document.getElementById('chart'));
    var myChart1 = echarts.init(document.getElementById('chart1'));
    var option = {
        color: colors,

        title: {
            text: '各个年级学习人数',
            x: 'center'
        },

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        grid: {
            top: '18%',
            right: '16%'
        },
        toolbox: {
            feature: {
                dataView: {
                    show: true,
                    readOnly: false
                },
                restore: {
                    show: true
                },
                saveAsImage: {
                    show: true
                }
            }
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男', '女']
        },
        xAxis: [{
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            data: ['高中', '初中', '小学']
        }],
        yAxis: [{
            type: 'value',
            name: '男',
            min: 0,
            max: 50,
            axisLine: {
                lineStyle: {
                    color: colors[0]
                }
            },
            axisLabel: {
                formatter: '{value} 人'
            }
        },
            {
                type: 'value',
                name: '女',
                min: 0,
                max: 50,
                position: 'right',
                axisLine: {
                    lineStyle: {
                        color: colors[1]
                    }
                },
                axisLabel: {
                    formatter: '{value} 人'
                }
            }
        ],
        series: [{
            name: '男',
            type: 'bar',
            data: [${boyedu.high},${boyedu.middle}, ${boyedu.primary}]
        },
            {
                name: '女',
                type: 'bar',
                yAxisIndex: 1,
                data: [${girledu.high}, ${girledu.middle}, ${girledu.primary}]
            }
        ]
    };
    myChart.setOption(option);

    var options = {
        color: colors,

        title: {
            text: '各个年级学生比例',
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
            data: ['高中', '初中', '小学']
        },
        series: [{
            name: '大学生家教',
            type: 'pie',
            selectedMode: 'single',
            radius: '55%',
            center: ['50%', '50%'],
            data: [{
                value: ${girledu.high}+${boyedu.high},
                name: '高中',
            },
                {
                    value: ${girledu.middle}+${boyedu.middle},
                    name: '初中',
                },
                {
                    value: ${girledu.primary}+${boyedu.primary},
                    name: '小学'
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
