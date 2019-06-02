<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script src="layui/layui.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <style>

        #top {
            height: 50px;
            background: #393D49;
        }

        .main {
            width: 80%;
            margin: 30px auto;
        }
    </style>
    <script>
        layui.use(['jquery', 'layer'], function () {
            var $ = layui.$;//重点处
            var layer = layui.layer;
            /**********添加功能**************************************************************/
            $("#add").click(function () {
                layer.open({
                    title: "添加",
                    type: 2,
                    area: ['500px', '480px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: 'add',
                    end: function () {
                        if($("#isAdd").val()==="ok"){
                            setTimeout("location.reload();", 500);
                        }

                    }
                });
            });


            /************修改功能******************************************************/

            $(".edit").click(function () {
                var id = $(this).val();
                layer.open({
                    title: "编号：" + id,
                    type: 2,
                    area: ['700px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: 'edit?id=' + id,
                    end: function () {
                        if($("#isEdit").val()==="ok"){
                        setTimeout("location.reload();", 500);
                        }
                    }
                });


            });




            /***************删除功能*****************************************************************/

            $(".del").click(function () {

                var btn = $(this);
                layer.confirm('您确定要删除编号为：' + $(this).val() + '  这条记录？', {
                    btn: ['确定', '再想想']
                }, function () {
                    $.ajax({
                        url: "del",
                        data: {
                            id: btn.val()
                        },
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            if (data.succ === "ok") {
                                layer.msg(data.data + "删除成功", {icon: 1});
                                setTimeout(" location.reload();", 500);
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    });


                }, function () {
                    layer.msg('还好没删除！', {icon: 6});
                });
            });


        });

    </script>
</head>
<body>
<input type="hidden" id="isEdit">
<input type="hidden" id="isAdd">

<div id="top"></div>
<div class="main">
    <button class="layui-btn layui-btn-sm" id="add">添加</button>
    <a href="chart"><button class="layui-btn layui-btn-sm" id="tb">图表</button></a>
    <br>
    <table class="layui-table">
        <thead>
        <tr>
            <th>编号</th>
            <th>时间</th>
            <th>金额</th>
            <th>支付方式</th>
            <th>消费类型</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach items="${page.list }" var="temp">
            <tr>
                <td>${temp.id }</td>
                <td><fmt:formatDate pattern="yyyy年MM月dd日" value="${temp.date}"/></td>
                <td>￥ ${temp.money }</td>
                <td>${temp.pay_mode }</td>
                <td>${temp.type }</td>
                <td>${temp.msg }</td>
                <td>
                    <button class="edit layui-btn layui-btn-sm" value="${temp.id}">修改</button>
                    <button value="${temp.id}" class="del layui-btn layui-btn-sm layui-btn-danger">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    总页数：${page.total} <br/>
    当前页：${page.pageNum }<br/>


    <a href="index">首页</a>
    <a href="index?start=${page.pageNum-1 }" <c:if
            test="${page.pageNum<=1 }"> onclick="javascript:return false;"</c:if>>上一页</a>
    <a href="index?start=${page.pageNum+1 }" <c:if
            test="${page.pageNum>=page.total}"> onclick="javascript:return false;"</c:if>>下一页</a>
    <a href="index?start=${page.total}">末页</a>


</div>
</body>
</html>