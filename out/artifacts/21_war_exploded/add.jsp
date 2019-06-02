<%--
  Created by IntelliJ IDEA.
  User: XiaoXin-700
  Date: 2018/12/11
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>记账</title>
    <script src="layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <style>


        #con {
            width: 300px;
            margin: 20px auto;
        }

        #btn_div {
            width: 100%;
        }

        #btn-reset {
            float: right;
        }

    </style>
    <script>
        layui.use(['element', 'form', 'laydate','jquery'], function () {
            var element = layui.element
                , form = layui.form
                ,$ = layui.$
                , laydate = layui.laydate;
            var index = parent.layer.getFrameIndex(window.name);

            // form.render('select','pay');
            //使用模块
            laydate.render({
                elem: '#date'
            });

            form.on('submit(up)', function(data){
                $.ajax({
                    url:"add_submit",
                    data:data.field,
                    type:"post",
                    dataType:"json",
                    success:function (data) {
                        if(data.succ==="ok"){
                            $("#isAdd", parent.document).val("ok");
                            parent.layer.close(index);
                            parent.layer.msg("添加成功", {icon: 1});
                        }else{
                            layer.msg("添加失败，请核对要修改的信息！",function () {});
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

</head>
<body>
<div id="con">
    <form action="add_submit"  method="post" class="layui-form">
        <input type="text" id="date" name="date" placeholder="yyyy年MM月dd日" class="layui-input" lay-verify="required">
        <br>
        <input type="text" id="money" name="money" placeholder="请输入金额" class="layui-input" lay-verify="number"><br>

        <select name="pay_mode" lay-filter="pay" lay-verify="required">
            <option value="">请选择一种支付方式</option>
            <option value="支付宝">支付宝</option>
            <option value="微信">微信</option>
            <option value="京东">京东</option>
            <option value="现金">现金</option>
        </select>
        <br>
        <select name="type" lay-search lay-verify="required">
            <option value="">请选择消费类型</option>
            <option value="餐饮">餐饮</option>
            <option value="零花">零花</option>
            <option value="交通">交通</option>
            <option value="医疗">医疗</option>
            <option value="生活">生活</option>
            <option value="消费">消费</option>
            <option value="通讯">通讯</option>
            <option value="娱乐">娱乐</option>
            <option value="购物">购物</option>
            <option value="教育">教育</option>
            <option value="还款">还款</option>
            <option value="其他">其他</option>
        </select><br>
        <textarea name="msg" required lay-verify="required" placeholder="备注：" class="layui-textarea"></textarea>
        <br>
        <div id="btn_div">
            <button class="layui-btn" lay-submit   lay-filter="up" >立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary" id="btn-reset">重置</button>
        </div>
    </form>
</div>
</div>

</body>

</html>
