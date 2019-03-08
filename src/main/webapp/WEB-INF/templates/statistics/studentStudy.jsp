<%--
  Created by IntelliJ IDEA.
  User: ruige
  Date: 2018/10/7
  Time: 10:37
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
<div id="chart" style="width: 100%;height: 620px;"></div>
<script type="text/javascript">
    var colors = ['#00BFFF', '#FFA07A', '#675bba'];
    var myChart = echarts.init(document.getElementById('chart'));
    var option = {
        color: colors,

        title: {
            text: '各个科目学习人数',
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
            data: ['男', '女', '总人数']
        },
        xAxis: [{
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            data: ['语文', '数学', '英语', '物理', '化学', '生物']
        }],
        yAxis: [{
            type: 'value',
            name: '男',
            min: 0,
            max: 50,
            position: 'right',
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
                offset: 80,
                axisLine: {
                    lineStyle: {
                        color: colors[1]
                    }
                },
                axisLabel: {
                    formatter: '{value} 人'
                }
            },
            {
                type: 'value',
                name: '人数',
                min: 0,
                max: 100,
                position: 'left',
                axisLine: {
                    lineStyle: {
                        color: colors[2]
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
            data: [${boycourse.chinese}, ${boycourse.math}, ${boycourse.english}, ${boycourse.physics}, ${boycourse.chemistry}, ${boycourse.biology}]
        },
            {
                name: '女',
                type: 'bar',
                yAxisIndex: 1,
                data: [${girlcourse.chinese}, ${girlcourse.math}, ${girlcourse.english}, ${girlcourse.physics}, ${girlcourse.chemistry}, ${girlcourse.biology}]
            },
            {
                name: '总人数',
                type: 'line',
                yAxisIndex: 2,
                data: [${boycourse.chinese}+${girlcourse.chinese}, ${boycourse.math}+${girlcourse.math}, ${boycourse.english}+${girlcourse.english}, ${boycourse.physics}+${girlcourse.physics}, ${boycourse.chemistry}+${girlcourse.chemistry}, ${boycourse.biology}+${girlcourse.biology}]
            }
        ]
    };
    myChart.setOption(option);
</script>
</body>

</html>
