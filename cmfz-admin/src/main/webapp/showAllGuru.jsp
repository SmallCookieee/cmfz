<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/6
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#showAllGuru").datagrid({
            url:"${pageContext.request.contextPath}/guru/showAllGuru",
            columns:[[
                {field:"guruId",title:"ID",width:100},
                {field:"guruName",title:"上师法名",width:100},
                {field:"guruPhoto",title:"上师图像",width:100},
                {field:"guruSummary",title:"上师描述",width:100},
            ]],
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:10,
            toolbar:"#gurubt",
            fitColumns:true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/guruPic/' + rowData.guruPhoto + '.jpg" style="height:200px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addGuru").linkbutton({
            onClick:function () {
                $("#guru").dialog({
                    title:"新增上师",
                    width:400,
                    height:170,
                    href:"${pageContext.request.contextPath}/addGuru.jsp",
                    buttons:[{
                        text:"添加",
                        iconCls:"icon-ok",
                        handler:function () {
                            $("#insertGuru").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/insertGuru",
                                onSubmit:function(){
                                    var isValid = $(this).form("validate");
                                    if (!isValid){
                                        $.messager.progress('close');
                                    }
                                    return isValid;
                                },
                                success:function(){
                                    $("#guru").dialog("close");
                                    $("#showAllGuru").datagrid("reload");
                                },
                            });
                        }
                    }]
                });
            }
        });
        $("#updateGuru").linkbutton({
            onClick:function () {

                var row = $("#showAllGuru").datagrid("getSelected");

                $("#guru").dialog({
                    title:"修改上师信息",
                    width:500,
                    height:180,
                    href:"${pageContext.request.contextPath}/updateGuru.jsp",
                    onLoad:function () {
                        $("#updateGuru").form("load",row);
                    },
                    buttons:[{
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function () {
                            $("#updateGuru").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/updateGuru",
                                onSubmit:function(){
                                    var isValid = $(this).form("validate");
                                    if (!isValid){
                                        $.messager.progress('close');
                                    }
                                    return isValid;
                                },
                                success:function(){
                                    $("#guru").dialog("close");
                                    $("#showAllGuru").datagrid("reload");
                                },
                            });
                        }
                    }]
                });
            }
        });
        $('#serachGuruByName').searchbox({
            searcher:function(value){
                alert(value);
                $("#showAllGuru").datagrid({
                    url:"${pageContext.request.contextPath}/guru/showGuruByName",
                    queryParams:{name:value},
                    columns:[[
                        {field:"guruId",title:"ID",width:100},
                        {field:"guruName",title:"上师法名",width:100},
                        {field:"guruPhoto",title:"上师图像",width:100},
                        {field:"guruSummary",title:"上师描述",width:100},
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
                            '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/guruPic/' + rowData.guruPhoto + '.jpg" style="height:200px;"></td>' +
                            '<td style="border:0">' +
                            '</td>' +
                            '</tr></table>';
                    }
                });
            },
            menu:'#mm',
            prompt:'请输入值'
        });
        $("#insertmore").linkbutton({
            onClick:function () {
                $("#guru").dialog({
                    title:"批量插入上师",
                    width:500,
                    height:100,
                    href:"${pageContext.request.contextPath}/addMoreGuru.jsp",
                    buttons:[{
                        text:"提交",
                        iconCls:"icon-ok",
                        handler:function () {
                            $("#insertMoreGuru").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/insertBatch",
                                onSubmit:function(){
                                    var isValid = $(this).form("validate");
                                    if (!isValid){
                                        $.messager.progress('close');
                                    }
                                    return isValid;
                                },
                                success:function(){
                                    $("#guru").dialog("close");
                                    $("#showAllGuru").datagrid("reload");
                                },
                            });
                        }
                    }]
                })
            }
        })
    });
</script>

<table id="showAllGuru"></table>
<div id="gurubt" style="display: none">
    <a id="addGuru" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>
    <a id="updateGuru" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'"></a>
    <input id="serachGuruByName"/>
    <div id="mm" style="width:150px">
        <div data-options="iconCls:'icon-ok'">法号</div>
    </div>
    <a id="insertmore" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
</div>

<div id="guru"></div>