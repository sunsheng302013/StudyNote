package com.cq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.dao.FormMapper;
import com.cq.dao.UserMapper;
import com.cq.model.Form;
import com.cq.model.User;

@RestController
@RequestMapping("/workflow")
public class WorkFlowController {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    FormMapper formMapper;

    @Autowired
    UserMapper userMapper;

    // 加载BPMN文件，创建请假流程
    @RequestMapping(value = "/startflow", method = RequestMethod.GET)
    public void startVacationProcess(String processName, Form form) {
        System.out.println("=====>加载BPMN文件，创建请假流程<=====");
        String resource = "diagrams/" + processName;
        repositoryService.createDeployment().addClasspathResource(resource).deploy();
        formMapper.insertSelective(form);
    }

    // 创建请假申请
    @RequestMapping(value = "/createvacation", method = RequestMethod.GET)
    public void createVacation(String processName, int formId) {
        System.out.println("=====>创建请假申请<=====");
        Form form = formMapper.selectByPrimaryKey(formId);
        User employee = userMapper.selectByPrimaryKey(form.getUserId());
        String businessKey = String.valueOf(form.getId());

        Map<String, Object> employeeValue = new HashMap<>();
        employeeValue.put("employee", employee.getUserName());

        runtimeService.startProcessInstanceByKey(processName, businessKey, employeeValue);
    }

    // 查询个人任务
    @RequestMapping(value = "/querypersontask", method = RequestMethod.GET)
    public List<Form> queryPersonTask(String userName) {
        System.out.println("=====>查询个人任务<=====");
        List<Form> formList = new ArrayList<Form>(10);

        TaskQuery tq = taskService.createTaskQuery().taskAssignee(userName);
        List<Task> lt = tq.list();
        for (Task task : lt) {
            String businessKeyId = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey();
            Form form = formMapper.selectByPrimaryKey(Integer.valueOf(businessKeyId));
            form.setTaskId(task.getId());
            formList.add(form);
        }
        return formList;
    }

    // 执行任务
    @RequestMapping(value = "/finishtask", method = RequestMethod.GET)
    public String finishTask(Form form) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("days", form.getDays());
        variables.put("manager", "manager");
        variables.put("hr", "hr");
        taskService.complete(form.getTaskId(), variables);
        return "完成任务：任务ID为：" + form.getTaskId();
    }
}
