<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/8
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {

    })
</script>
<form id="updateGuru" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上师ID:</td>
            <td>
                <input name="guruId" class="easyui-textbox" data-options="width:251" readonly/>
            </td>
        </tr>
        <tr>
            <td>上师法号:</td>
            <td>
                <input id="guruName" name="guruName" class="easyui-textbox" data-options="width:251"/>
            </td>
        </tr>
        <tr>
            <td>上师图像:</td>
            <td>
                <input name="file" id="files" class="easyui-filebox" data-options=" buttonText: '选择图像',buttonIcon:'icon-add',buttonAlign: 'right',accept:'.jpg',width:251">
            </td>
        </tr>
        <tr>
            <td>上师描述:</td>
            <td>
                <input id="guruSummary" name="guruSummary" class="easyui-textbox" data-options="width:251"/>
            </td>
        </tr>
    </table>
</form>
