<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2018/7/9
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';
    editor.customConfig.uploadFileName = 'files';
    editor.create();
    $(function () {
        $("#articleAuthor").combobox({
            url:"${pageContext.request.contextPath}/article/showAllGuru",
            valueField:"guruName",
            textField:"guruName",
            required:"true",
        });
        $("#articleStatus").switchbutton({
            onText:"已上架",
            offText:"未上架",
        });
        $("#submitArticle").linkbutton({
            text:"创建文章",
            iconCls:"icon-ok",
            onClick:function () {
                $("#insertGuru").form("submit",{
                    url:"${pageContext.request.contextPath}/article/addArticle",
                    onSubmit:function (param) {
                        param.introduction=editor.txt.html();
                        return $(this).form("validate");
                    },
                    success:function (data) {
                        if(data==""){
                            $.messager.show({
                                title:"创建文章",
                                msg:"创建失败！窗口在3秒后关闭",
                                timeout:3000,
                            });
                            $("#insertGuru").form("reset");
                        }else {
                            $.messager.show({
                                title:"创建文章",
                                msg:"创建成功！窗口在3秒后关闭",
                                timeout:3000,
                            });
                            $("#insertGuru").form("reset");
                        }
                    }
                })
            }
        });
        $("#resetArticle").linkbutton({
            text:"重置内容",
            iconCls:"icon-reload",
            onClick:function () {
                $("#insertGuru").form("reset");
            }
        })
    })
</script>
<form id="insertGuru" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>文章标题:</td>
            <td>
                <input name="articleName" class="easyui-textbox"/>
            </td>
        </tr>
        <tr>
            <td>文章作者:</td>
            <td>
                <input id="articleAuthor" name="articleAuthor"/>
            </td>
        </tr>
        <tr>
            <td>文章状态:</td>
            <td>
                <input id="articleStatus" name="articleStatus" />
            </td>
        </tr>
        <tr>
            <td colspan="2">文章内容:</td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="editor" name="introduction"></div>
            </td>
        </tr>
        <tr>
            <td>
                <a id="submitArticle"></a>
                <a id="resetArticle"></a>
            </td>
        </tr>
    </table>
</form>

