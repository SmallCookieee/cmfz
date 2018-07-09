<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/6
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<form id="insertGuru" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上师法名:</td>
            <td>
                <input id="name" name="guruName" class="easyui-textbox" data-options="width:251"/>
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
                <input id="summary" name="guruSummary" class="easyui-textbox" data-options="width:251"/>
            </td>
        </tr>
    </table>
</form>