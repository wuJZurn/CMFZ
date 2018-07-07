<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">

$(function() {
    $('#subMast').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right'
    })

});

</script>

<div style="margin-top: 40px;margin-left: 60px">
	<form id="ffSubMaster" method="post" enctype="multipart/form-data">
		<p>上传批量添加文件(EXCEL):
			<input id="subMast" name="subfile" class="easyui-filebox" ></p>
	</form>
</div>


