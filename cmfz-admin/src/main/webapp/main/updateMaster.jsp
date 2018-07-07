<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">

$(function() {

    $('#masterSummary').textbox({
        multiline:true,
		height:50
	});

    $('#masterPic').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right'
    })

});

</script>

<div style="margin-top: 35px;margin-left: 75px">
	<form id="ffUpdateMaster" method="post" enctype="multipart/form-data">
		<input name="masterId" hidden="hidden">
		<p>上师姓名：<input id="masterName" class="easyui-textbox" name="masterName"></p>
		<p>上师简介：<input id="masterSummary" class="easyui-textbox"  name="masterSummary"></p>
		<p>上师图像：<input id="masterPic" name="masterPhoto" readonly="readonly" class="easyui-filebox" ></p>
	</form>
</div>


