<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/6
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<form id="addPic" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>轮播图ID:</td>
            <td>
                <input id="pid" name="picId" class="easyui-textbox" data-options="width:251" readonly/>
            </td>
        </tr>
        <tr>
            <td>轮播图描述:</td>
            <td>
                <input id="des" name="description" class="easyui-textbox" data-options="width:251"/>
            </td>
        </tr>
        <tr>
            <td>轮播图状态:</td>
            <td>
                <select id="sts" class="easyui-combobox" data-options="panelHeight:50,width:251" name="status">
                    <option value="未展示">未展示</option>
                    <option value="展示中">展示中</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>请选择图片:</td>
            <td>
                <input name="file" id="files" class="easyui-filebox" data-options=" buttonText: '选择文件',buttonIcon:'icon-add',buttonAlign: 'right',accept:'.jpg',width:251">
            </td>
        </tr>
    </table>
</form>
