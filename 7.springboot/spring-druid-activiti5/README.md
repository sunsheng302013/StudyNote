# springboot整合activiti

项目整合了activiti和druid，druid主要是方便查看activiti对数据库进行的操作

项目需要修改的地方：
resources/application.yml中将mysql地址修改为自己本地的地址，其他地方不需要修改

项目运行：
运行com.cq下ActivitiTestApplication即可，activiti会自动在数据库中生成25张需要的表

druid也会自动启动，浏览器登录localhost:8080/druid/login.html可以查看
----------------------------------------------------------------------
1. 加载流程
localhost:8080/deployment/createdeployment
参数：processResource(BPMN文件路径+名称)
项目中参数为 processResource=diagrams/MyProcess.bpmn

2. 启动流程
localhost:8080/runtime/start
参数：processKey(BPMN文件id)
项目中参数为：?processKey=myProcess

3. 查询个人任务
localhost:8080/task/findpersonaltask
参数：assignee(任务办理人assignee,BPMN文件中assignee)
项目中参数为：?assignee=王五

4. 执行任务
localhost:8080/task/finishtask
参数：?taskId(任务id）
项目中参数为：?taskId=
按照BPMN流程图依次执行
先申请人申请，主管审批，老板审批