<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>

<script type="text/javascript">
$(function() {

    $('#ttMaster').datagrid({
		height:538,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:'${pageContext.request.contextPath}/master/showMaster',
        columns:[[
            {field:'masterId',title:'上师编号',width:100},
            {field:'masterName',title:'上师名',width:80,sortable:true},
            {field:'masterPhoto',title:'上师图像名',width:80,sortable:true},
            {field:'masterSummary',title:'上师简介',width:200,sortable:true},
            {field:'status',title:'操作',width:60,align:'center',formatter:function(value,row,index){
                //$("#del").linkbutton({});
                return "<a class='easyui-linkbutton' data-options=\"height:20,iconCls:'icon-edit'\" onClick='modMasterBtn()'>修改</a>";
            }}
        ]],
        onLoadSuccess:function(){
            $.parser.parse();
        },
        pagination:true,
        pageList : [ 5, 10, 15, 20, 25 ],
        pageSize : 5,
        toolbar : "#tb",

        view: detailview,
        detailFormatter: function(rowIndex, rowData){
			return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="/admin/upload/master' + rowData.masterPhoto + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '</td>' +
                '</tr></table>';
        }
    });


    $("#addMaster").linkbutton({
        onClick:function(){
            $("#dialogMaster").dialog({

                iconCls:'icon-pictures',
                width:400,
                height:250,
                title:"添加上师",
                href:"${pageContext.request.contextPath}/main/formMaster.jsp",
                modal:true,
				minimizable:true,
				maximizable:true,
                buttons:[{
                    iconCls:"icon-dvd_add",
                    text:"上传",
                    handler:function(){
                        //提交
                        $("#ffMaster").form("submit",{
                            url:"${pageContext.request.contextPath}/master/addMaster",
                            onSubmit:function(){
                                return $("#ffMaster").form("validate");
                            },
                            success:function(res){
                                if(res == "success"){
                                    $.messager.show({
                                        title:"提示",
                                        msg:"添加成功！",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialogMaster").dialog("close");
                                    $("#ttMaster").datagrid({
                                        url:"${pageContext.request.contextPath}/master/showMaster",
                                    });
                                }else{
                                    $.messager.show({
                                        title:"提示",
                                        msg:"添加失败！",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialogMaster").dialog("close");
                                }
                            }
                        });
                    }
                },{
                    iconCls:"icon-cancel",
                    text:"取消",
                    handler:function(){
                        $("#dialogMaster").dialog("close");
                    }
                }],
            });

        }
    });

    $("#subBtn").linkbutton({
        onClick:function(){
            $("#dialogMaster").dialog({

                iconCls:'icon-pictures',
                width:300,
                height:200,
                title:"添加批量上传文件",
                href:"${pageContext.request.contextPath}/main/subMaster.jsp",
                modal:true,
                minimizable:true,
                maximizable:true,
                buttons:[{
                    iconCls:"icon-dvd_add",
                    text:"上传",
                    handler:function(){
                        //提交
                        $("#ffSubMaster").form("submit",{
                            url:"${pageContext.request.contextPath}/master/importMaster",
                            onSubmit:function(){
                                return $("#ffSubMaster").form("validate");
                            },
                            success:function(res){
                                if(res == "success"){
                                    $.messager.show({
                                        title:"提示",
                                        msg:"添加成功！正在上传！",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialogMaster").dialog("close");
                                    $("#ttMaster").datagrid({
                                        url:"${pageContext.request.contextPath}/master/showMaster",
                                    });
                                }else{
                                    $.messager.show({
                                        title:"提示",
                                        msg:"上传失败！",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialogMaster").dialog("close");
                                }
                            }
                        });
                    }
                },{
                    iconCls:"icon-cancel",
                    text:"取消",
                    handler:function(){
                        $("#dialogMaster").dialog("close");
                    }
                }],
            });

        }
    });



    $('#ss').searchbox({
        searcher:function(value,name){
            $('#ttMaster').datagrid({
                url:'${pageContext.request.contextPath}/master/showMaster?seleName='+value,
            });
        },
        menu:'#mm',
        prompt:'请输入关键字'
    });

    $('#subMasters').filebox({
        buttonText: '选择文件',
        buttonAlign: 'left'
    })



});

function modMasterBtn(){
    $("#dialogMaster").dialog({
        iconCls:'icon-pictures',
        width:400,
        height:250,
        title:"修改上师信息",
        href:"${pageContext.request.contextPath}/main/updateMaster.jsp",
        modal:true,
        minimizable:true,
        maximizable:true,
        onLoad:function(){
            var rowData = $("#ttMaster").datagrid("getSelected");
            $("#ffUpdateMaster").form("load",rowData);
        },

        buttons:[{
            iconCls:"icon-dvd_add",
            text:"修改",
            handler:function(){
                //提交
                $("#ffUpdateMaster").form("submit",{
                    url:"${pageContext.request.contextPath}/master/modifyMaster",
                    onSubmit:function(){
                        return $("#ffUpdateMaster").form("validate");
                    },
                    success:function(res){
                        if(res == "success"){
                            $.messager.show({
                                title:"提示",
                                msg:"修改成功！",
                                timeout:5000,
                                showType:"slider",
                            });
                            $("#dialogMaster").dialog("close");
                            $("#ttMaster").datagrid({
                                url:"${pageContext.request.contextPath}/master/showMaster",
                            });
                        }else{
                            $.messager.show({
                                title:"提示",
                                msg:"修改失败！",
                                timeout:5000,
                                showType:"slider",
                            });
                            $("#dialogMaster").dialog("close");
                        }
                    }
                });
            }
        },{
            iconCls:"icon-cancel",
            text:"取消",
            handler:function(){
                $("#dialogMaster").dialog("close");
            }
        }],
    });
}


</script>

<div>
	<div id="tbMaster">
		<a id="addMaster" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'添加上师'"></a>
		<a id="helpMaster" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
		<a id="editMaster" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'编辑'"></a>
		&nbsp
		<input id="ss" style="width: 200px" />
		<div id="mm" style="width:80px">
			<div data-options="name:'all'">姓名</div>
		</div>
		&nbsp
		<a id="subBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量添加'"></a>
	</div>
</div>
<table id="ttMaster"></table>
<div id="dialogMaster"></div>

