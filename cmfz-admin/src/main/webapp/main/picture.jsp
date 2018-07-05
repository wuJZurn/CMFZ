<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>

<script type="text/javascript">
$(function() {

    $('#tt1').datagrid({
		height:570,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:'${pageContext.request.contextPath}/picture/showPic',
        columns:[[
            {field:'pictureId',title:'标识编号',width:100},
            {field:'picturePath',title:'文件名',width:80,sortable:true},
            {field:'pictureDescription',title:'描述信息',width:80,sortable:true},
            {field:'pictureStatus',title:'轮播图状态',width:80,sortable:true},
            {field:'pictureDate',title:'轮播图创建时间',width:80,sortable:true},
            {field:'status',title:'操作',width:60,align:'center',formatter:function(value,row,index){
                //$("#del").linkbutton({});
                return "<a class='easyui-linkbutton' data-options=\"height:20,iconCls:'icon-edit'\" onClick='modfiyBtn()'>修改</a>";
            }}
        ]],
        onLoadSuccess:function(){
			/* console.log(11);
			 $(".btn").linkbutton({}); */
            $.parser.parse();
        },
        pagination:true,
        pageList : [ 5, 10, 15, 20, 25 ],
        pageSize : 5,
        toolbar : "#tb",

        view: detailview,
        detailFormatter: function(rowIndex, rowData){
			return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="/admin/upload' + rowData.picturePath + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>描述: ' + rowData.pictureDescription + '</p>' +
                '<p>状态: ' + rowData.pictureStatus + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });

    $("#addPic").linkbutton({
        onClick:function(){
            $("#dialog").dialog({

                iconCls:'icon-pictures',
                width:400,
                height:250,
                title:"新增轮播图",
                href:"${pageContext.request.contextPath}/main/formPic.jsp",
                modal:true,
				minimizable:true,
				maximizable:true,
                buttons:[{
                    iconCls:"icon-dvd_add",
                    text:"上传",
                    handler:function(){
                        //提交
                        $("#ff").form("submit",{
                            url:"${pageContext.request.contextPath}/picture/addPic",
                            onSubmit:function(){
                                return $("#ff").form("validate");
                            },
                            success:function(res){
                                if(res == "success"){
                                    $.messager.show({
                                        title:"提示",
                                        msg:"上传成功！",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                    $("#dg").datagrid({
                                        url:"${pageContext.request.contextPath}/main/main.jsp",
                                    });
                                }else{
                                    $.messager.show({
                                        title:"提示",
                                        msg:"上传失败！",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                }
                            }
                        });
                    }
                },{
                    iconCls:"icon-cancel",
                    text:"取消",
                    handler:function(){
                        $("#dialog").dialog("close");
                    }
                }],
            });

        }
    });
});

</script>

<div>
	<div id="tb">
		<a id="addPic" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
		<a id="helpPic" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
	</div>
</div>
<table id="tt1"></table>
<div id="dialog"></div>

