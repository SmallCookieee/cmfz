<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/5
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#show").datagrid({
            url:"${pageContext.request.contextPath}/shuffling/showAllPic",
            columns:[[
                {field:"id",title:"ID",width:100},
                {field:"path",title:"路径",width:100},
                {field:"date",title:"上传日期",width:100},
                {field:"description",title:"描述",width:100},
                {field:"status",title:"轮播图状态",width:100},
            ]],
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:10,
            toolbar:"#tb",
            fitColumns:true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/images/' + rowData.path + '.jpg" style="height:200px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#add").linkbutton({
            onClick:function () {
                $("#dd").dialog({
                    title:"新增轮播图",
                    width:500,
                    height:160,
                    href:"${pageContext.request.contextPath}/addPic.jsp",
                    buttons:[{
                        text:"添加",
                        iconCls:"icon-ok",
                        handler:function () {
                            $("#addPic").form("submit",{
                                url:"${pageContext.request.contextPath}/shuffling/insertPic",
                                onSubmit:function(){
                                    var isValid = $(this).form("validate");
                                    if (!isValid){
                                        $.messager.progress('close');
                                    }
                                    return isValid;
                                },
                                success:function(){
                                    $("#dd").dialog("close");
                                    $("#show").datagrid("reload");

                                },
                            });
                            $.messager.show({
                                title:"添加成功!",
                                msg:"上传成功，窗口在3秒后关闭",
                                timeout:3000,
                            });
                        }

                    }]
                })
            }
        });
        $("#update").linkbutton({
            onClick:function () {
                var rowData = $("#show").datagrid("getSelected");
                $("#dd").dialog({
                    title:"修改图片信息",
                    width:500,
                    height:160,
                    href:"${pageContext.request.contextPath}/updatePic.jsp",
                    onLoad:function(){
                        $("#updatePic").form("load",rowData);
                    },
                    buttons:[{
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function () {
                            $("#updatePic").form("submit",{
                                url:"${pageContext.request.contextPath}/shuffling/updatePic",
                                onSubmit:function(){
                                    var isValid = $(this).form("validate");
                                    if (!isValid){
                                        $.messager.progress('close');
                                    }
                                    return isValid;
                                },
                                success:function(){
                                    $("#dd").dialog("close");
                                    $("#show").datagrid("reload");
                                },
                            })
                        }
                    }]
                })
            }
        })
    })

</script>

<table id="show"></table>
<div id="tb" style="display: none">
    <a id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
    <a id="update" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
    <a id="help" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>
<div id="dd"></div>
