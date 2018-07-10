<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/10
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#showAllLog").datagrid({
            url:"${pageContext.request.contextPath}/log/showAllLog",
            columns:[[
                {field:"logId",title:"ID",width:100},
                {field:"logUser",title:"操作用户",width:100},
                {field:"logTime",title:"操作时间",width:100},
                {field:"logResource",title:"操作内容",width:100},
                {field:"logAction",title:"操作类型",width:100},
                {field:"logMessage",title:"操作信息",width:100},
                {field:"logResult",title:"操作结果",width:100},
            ]],
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:10,
            fitColumns:true,
            singleSelect:true,
        })
    })
</script>

<table id="showAllLog"></table>