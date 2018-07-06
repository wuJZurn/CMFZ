<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
$(function() {
    $('#setPic1').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right'
    })
});

</script>

<div style="margin-top: 40px;margin-left: 70px">
	<form id="ff2" method="post" enctype="multipart/form-data">
		<input name="pictureId" hidden="hidden">
		<input name="pictureDate" hidden="hidden">
		<p>轮播图描述：<input id="picDescrption1" class="easyui-textbox" name="pictureDescription"></p>
		<p>轮播图状态：<select id="picStatus1" panelHeight="auto" class="easyui-combobox" width="50px" name="pictureStatus">
				<option value="展示中">展示</option>
				<option value="未展示">不展示</option>
			</select>
		</p>
		<p>轮播图名称：<input id="setPic1" name="picturePath" readonly="readonly" ></p>
	</form>
</div>


