<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2018/7/8
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<form id="ffArticle" method="post" enctype="multipart/form-data">
<div style="margin-top: 35px;margin-left: 75px">
        <p>文章标题：<input id="articletitle" class="easyui-textbox" name="articleName"></p>
        <p>文章作者：<input id="articleName" class="easyui-textbox"  name="articleAuthor"></p>
        <p>文章状态：<input name="articleStatus" class="easyui-switchbutton" style="width: 80px" data-options="onText:'上架',offText:'未上架'"></p>
        <input id="editValue" name="introduction" type="text" hidden="hidden">
        <p>文章内容</p>
        <div id="editor" style="width: 800px"></div>
        </br>
        <a id="btn" onclick="addArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-database_save'">提交文章信息</a>
        <a id="btnClear" onclick="clearArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-database_refresh'">重置内容</a>

</div>
</form>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )

    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create();

    function clearArticle(){
        $("#ffArticle").form('clear');
        editor.txt.html('<p><br></p>');
    }

    function addArticle(){
        var text=editor.txt.html();
        document.getElementById("editValue").value=text;
        $("#ffArticle").form("submit",{
            url:"${pageContext.request.contextPath}/article/addArticle",
            success:function(res){
                if(res == "success"){
                    $.messager.show({
                        title:"提示",
                        msg:"上传成功！",
                        timeout:3000,
                        showType:"slider",
                    });
                    $("#ffArticle").form('clear');
                    editor.txt.html('<p><br></p>');
                }else{
                    $.messager.show({
                        title:"提示",
                        msg:"上传失败！",
                        timeout:3000,
                        showType:"slider",
                    });
                }
            }
        });
    }
</script>

