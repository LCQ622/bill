<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: XiaoXin-700
  Date: 2018/12/12
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script>

        layui.use(['element', 'form', 'laydate', 'jquery'], function () {
            var index = parent.layer.getFrameIndex(window.name);
            var element = layui.element
                , form = layui.form
                , $ = layui.$
                , laydate = layui.laydate;

            laydate.render({
                elem: '#date'
            });





            form.on('submit(up)', function(data){


                $.ajax({
                    url:"edit_submit",
                    data:data.field,
                    type:"post",
                    dataType:"json",
                    success:function (data) {
                        if(data.succ==="ok"){
                            parent.layer.close(index);
                            //设置父页面的元素的值
                            $("#isEdit", parent.document).val("ok");
                            parent.layer.msg("修改成功", {icon: 1});


                        }else{

                            layer.msg("修改失败，请核对要修改的信息！",function () {});
                        }
                    }
                });





                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });












            $("#btn-reset").click(function () {
                parent.layer.close(index);
            });


        });


    </script>

    <style>


        #con {
            width: 500px;
            margin: 20px auto;
        }

        #btn_div {
            width: 100%;
        }

        #btn-reset {
            float: right;
        }

    </style>
</head>
<body>


<div id="con">
    <form action="edit_submit" method="post" class="layui-form" id="form1">
        <input type="hidden" name="id" value="${bill.getId()}">
        <div class="layui-form-item">
            <label class="layui-form-label">消费日期:</label>
            <div class="layui-input-block">
                <input type="text" id="date" name="date" placeholder="yyyy年MM月dd日" class="layui-input"
                       lay-verify="required" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${bill.getDate()}" />">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">￥</label>
            <div class="layui-input-block">
                <input type="text" id="money" name="money" placeholder="请输入金额" class="layui-input" lay-verify="number"
                       value="${bill.getMoney()}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">支付方式:</label>
            <div class="layui-input-block">
                <select name="pay_mode" lay-filter="pay" lay-verify="required">
                    <option value="">请选择一种支付方式</option>
                    <option value="支付宝" <c:if test="${bill.getPay_mode() == '支付宝' }">selected</c:if>>支付宝</option>
                    <option value="微信"
                            <c:if test="${bill.getPay_mode() == '微信' }">selected</c:if> >微信
                    </option>
                    <option value="京东"
                            <c:if test="${bill.getPay_mode()== '京东' }">selected</c:if>  >京东
                    </option>
                    <option value="现金" <c:if test="${bill.getPay_mode() == '现金' }">selected</c:if>>现金</option>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">消费类型:</label>
            <div class="layui-input-block">
                <select name="type" lay-search lay-verify="required">
                    <option value="">请选择消费类型</option>
                    <option value="餐饮"
                            <c:if test="${bill.getType()== '餐饮' }">selected</c:if> >餐饮
                    </option>
                    <option value="零花"
                            <c:if test="${bill.getType() == '零花' }">selected</c:if> >零花
                    </option>
                    <option value="交通"
                            <c:if test="${bill.getType() == '交通' }">selected</c:if> >交通
                    </option>
                    <option value="医疗"
                            <c:if test="${bill.getType() == '医疗' }">selected</c:if> >医疗
                    </option>
                    <option value="生活" <c:if test="${bill.getType() == '生活' }">selected</c:if>>生活</option>
                    <option value="消费" <c:if test="${bill.getType() == '消费' }">selected</c:if>>消费</option>
                    <option value="通讯" <c:if test="${bill.getType() == '通讯' }">selected</c:if>>通讯</option>
                    <option value="娱乐" <c:if test="${bill.getType() == '娱乐' }">selected</c:if>>娱乐</option>
                    <option value="购物" <c:if test="${bill.getType() == '购物' }">selected</c:if>>购物</option>
                    <option value="教育" <c:if test="${bill.getType() == '教育' }">selected</c:if>>教育</option>
                    <option value="还款" <c:if test="${bill.getType() == '还款' }">selected</c:if>>还款</option>
                    <option value="其他" <c:if test="${bill.getType() == '其他' }">selected</c:if>>其他</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <textarea name="msg" required lay-verify="required" placeholder="备注："
                          class="layui-textarea">${bill.getMsg()}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"  lay-filter="up" lay-submit lay-filter="formDemo" id="btn">立即提交</button>
                <button type="reset"  class="layui-btn layui-btn-primary" id="btn-reset">重置</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>
