<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
	var datacom=[
        {
            "id": "未展示",
            "text": "不展示"
        },
        {
            "id": "展示中",
            "text": "展示"
        },
	];
$(function() {
    $('#picStatus').combobox({
            valueField: 'id',
            textField: 'text',
            data: datacom,
        }
    );

    $('#setPic').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right'
    })

});

</script>

<div style="margin-top: 40px;margin-left: 70px">
	<form id="ff" method="post" enctype="multipart/form-data">
		<p>轮播图描述：<input id="picDescrption" class="easyui-textbox" name="pictureDescription"></p>
		<p>轮播图状态：<input id="picStatus" panelHeight="auto" class="easyui-combobox" width="50px" name="pictureStatus"></p>
		<p>上传轮播图：<input id="setPic" name="myFile" class="easyui-filebox" ></p>
	</form>
</div>


