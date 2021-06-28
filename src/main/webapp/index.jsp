<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme()+"://"+
        request.getServerName()+":"+request.getServerPort()+
        request.getContextPath()+"/";
%>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        //页面加载完成之后立即加载数据
        loadMenus();
        $("#add").on("click" ,function () {
             console.log("点击事件生效");
             addMenu() ;
        })
    })
    function addMenu() {
        console.log("执行增加菜单")
        $.ajax({
            url:"addMenu",
            type: "post",
            dataType:"json",
            data:$("#addMenus").serialize(),
            success:function (data) {
                // loadMenus();
            }
        })
    }
    function imagUpload() {
        $.ajaxFileUpload({

        })
    }

    function loadMenus() {
        $.ajax({
            url:"queryAll",
            type:"get",
            dataType:"json",
            success:function (data) {
                $("#info").html("")
                $.each(data,function (i,n) {
                    //增加新的数据
                    $("#info").append("<tr>")
                    .append("<td>"+n.m_id+"</td>")
                    .append("<td>"+n.m_name+"</td>")
                    .append("<td>"+n.m_price+"</td>")
                    .append("<td>"+"<img>"+n.picture+"</img>"+"</td>")
                    .append("<td>"+n.remake+"</td>")
                    .append("</tr>")

                })
            }
        })
    }
</script>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<h2>Hello Menus</h2>
<form action="queryAll" method="post">
    <input type="text"/>
    <button type="submit" value="提交">提交</button>
</form>

    <div align="center">
        <form id="addMenus"  >
            名称：<input type="text" name="m_name"><br>
            价格：<input type="text" name="m_price"><br>
            图片：<input type="file" name="picture"><br>
            备注：<input type="text" name="remake"><br>
            <button id="add">增加</button>
        </form>

        <h3>springMVC普通上传</h3>
        <form action="fileUpload" enctype="multipart/form-data" method="post">
            <input type="file" name="upload"><br>
            <input type="submit" value="上传">
        </form>

        <h3>图片存入数据库</h3>
        <form id="addMenus2" action="uploadImg" enctype="multipart/form-data"  method="post" >
            图片：<input type="file" name="picture"><br>
            <button type="submit" >增加</button>
        </form>

        <table width="400px" border="3px">
            <thead >
                <tr>
                    <td>id</td>
                    <td>名称</td>
                    <td>价格</td>
                    <td>图片</td>
                    <td>备注</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
    </div>
</body>
</html>