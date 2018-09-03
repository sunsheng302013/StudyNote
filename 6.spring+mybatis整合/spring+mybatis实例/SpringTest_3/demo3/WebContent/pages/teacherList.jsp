<%@ page language="java" import="java.util.*"
    pageEncoding="UTF-8"%>

<%@page import ="com.mybatis.pojo.Teacher" %>
<%@include file="/common/common.jsp"%>
<%@include file="/common/common-ui.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<script type="text/javascript">

function deleteUser(id) {
    
    $("#msgBoxConfirmInfo").html("确定要删除该用户吗");
    $("#msgBoxConfirm").modal('show');
    $("#msgBoxConfirmButton").on('click' , function(){
        $("#msgBoxConfirm").modal('hide');
        $.ajax({
            type : 'POST',
            url : '${basePath}/teacher/delete',
            data : {
                'id' : id
            },
            dataType : 'json',
            success : function(data) {
                if (data.success) {
                    $("#msgBoxInfo").html(data.msg);
                    $("#msgBox").modal('show');
                    $("#msgBoxOKButton").on('click' , function(){
                        window.location.reload();
                    });
                } else {
                    $("#msgBoxInfo").html(data.msg);
                    $("#msgBox").modal('show');
                }
            },
            error : function(data) {
                $("#msgBoxInfo").html("程序执行出错");
                $("#msgBox").modal('show');
            }
        });
    });
    
}
    
    function showDialog(title , url , height){
        $("#modalDialogTitle").html(title);
        $("#modalDialogFrame").attr("height" , height);
        $("#modalDialogFrame").attr("src" , url);
        $("#modalDialog").modal('show');
    }
    
    function hideDialog(){
        $("#modalDialog").modal('hide');
    }
</script>

<head>
</head>

<body>
        <!-- 内容start -->
        <div class="up-tab-content">
            <div class="up-tab-pane up-active" id="tabs1">
                <div class="border_btm first_title">
                    <h4 class="up-top-cq-color" align="center">
                        <span class="icon-right-dir"></span> 教师列表
                    </h4>
                </div>
                <div class="up_page_con">
                    <div class="ex_tab2" role="tabpanel" data-example-id="togglable-tabs">
                        <div id="" class="up-tab-content">
                            <div role="tabpanel" class="up-tab-pane up-active" id="mytab11" aria-labelledby="mytab11-tab">
                                <div class="up-table-responsive">
                                    <div class="up-cq-table">
                                        <div class="up-cq-table-outer">
                                            <div class="up-cq-table-inner">
                                                <table
                                                    class="up-table up-table-bordered up-table-hover margin_bottom10 up-text-center">
                                                    <thead>
                                                        <tr class="up-active">
                                                            <th>教师id</th>
                                                            <th>姓名</th>
                                                            <th>年龄</th>
                                                            <th>课程</th>
                                                            <th>操作</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="teacher" items="${requestScope.teacherList}">
                                                            <tr>
                                                            <td>${teacher.id}</td>
                                                                <td>${teacher.name}</td>
                                                                <td>${teacher.age}</td>
                                                                <td>${teacher.course.courseName}</td>
                                                                <td>
                                                                    <a href="javascript:void(0)" onClick="showDialog('查看用户' , '${basePath}/userInfo/viewUser?id=${teacher.id}' , '280px')">查看</a> 
                                                                    <a href="javascript:void(0)" onClick="showDialog('编辑用户' , '${basePath}/userInfo/toAddOrEditUser?id=${teacher.id }' , '280px')">编辑</a>
                                                                    <a href="javascript:void(0)" onClick="deleteUser('${teacher.id}')">删除</a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>

                                                <div class="up-clearfix">
                                                    <div class="up-pull-right">
                                                        <%@include file="/common/page.jsp"%>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </main>
        
        <!-- 侧栏提示工具容器 -->
        <div id="tooltip_box"></div>
        <!-- 侧栏提示工具容器 -->

        <!--    提示框 start -->
        <%@include file="/common/msgBox.jsp"%>
        <!--    提示框 -->
        
         <div class="up-modal up-fade" id="modalDialog"  data-drag="true" data-backdrop="static">
          <div class="up-modal-dialog up-modal-lg">
            <div class="up-modal-content">
              <div class="up-modal-header">
                <button type="button" class="up-close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="up-modal-title" id="modalDialogTitle">新增用户</h4>
              </div>
              <iframe id="modalDialogFrame"  width="100%" height="300px" frameborder="0"></iframe>
            </div>
          </div>
        </div>
</body>

</html>
