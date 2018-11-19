/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.dto.WorkFlowDTO;
import com.cq.model.Flow;

/**
 * @since 2018年8月28日 下午4:15:13
 * @author huangyi
 *
 */
@RestController
@RequestMapping("/oa/")
public class TestFlowController extends BaseController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/test")
    public JackYunResponse<Object> create(Flow flow) {
        // 根据bpmn文件部署流程
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("\\processes\\438300051069050752.bpmn20.xml").deploy();
        // 获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
        Map<String, Object> variables = new HashMap<>();
        variables.put("user", "huangyi");
        variables.put("position", 1);
        // 启动流程定义，返回流程实例
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId(), variables);
        String processId = pi.getId();
        System.err.println("流程创建成功，当前流程实例ID：" + processId);

        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.err.println("执行前，任务名称：" + task.getName());
        taskService.complete(task.getId());

        List<Task> list = taskService.createTaskQuery().taskAssignee("huangyi").list();
        Map<String, Object> variablesNext = new HashMap<>();
        variablesNext.put("user", "zhangsan");
        variablesNext.put("days", "11");
        taskService.complete(list.get(0).getId(), variablesNext);

        return sendSuccess();
    }

    /**
     * 查询用户的待办任务
     */
    @RequestMapping("findtasklistbyname")
    public List<WorkFlowDTO> findTaskListByName(String name) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(name).orderByTaskCreateTime().asc().list();
        List<WorkFlowDTO> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (org.activiti.engine.task.Task task : list) {
                // 通过流程实例id获取流程实例对象，从而获取businessKey
                String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey();
                // 查询出申请单据
                WorkFlowDTO flowDTO = new WorkFlowDTO();
                flowDTO.setTaskId(task.getId());
                flowDTO.setApprover(task.getAssignee());
                flowDTO.setTaskName(task.getName());
                flowDTO.setTaskCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getCreateTime()));
                flowDTO.setBusinessKey(businessKey);
                // flowDTO.setFlowId(task.getProcessInstanceId());
                resultList.add(flowDTO);
            }
        }
        return resultList;
    }

}
