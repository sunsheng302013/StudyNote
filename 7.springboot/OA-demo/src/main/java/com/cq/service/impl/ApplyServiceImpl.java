/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cq.common.annotation.DS;
import com.cq.common.util.DeserializationConverter;
import com.cq.common.util.SessionUtil;
import com.cq.dao.DeployDao;
import com.cq.dao.FlowHistoryDao;
import com.cq.dao.FormDao;
import com.cq.dao.UserFlowDao;
import com.cq.dto.CirculationDTO;
import com.cq.dto.ExamineDTO;
import com.cq.dto.ExamineResultDTO;
import com.cq.dto.FlowDTO;
import com.cq.dto.WorkFlowDTO;
import com.cq.model.FlowHistory;
import com.cq.model.FlowNode;
import com.cq.model.User;
import com.cq.model.UserFlow;
import com.cq.service.ApplyService;

/**
 * @since 2018年8月28日 下午6:26:07
 * @author huangyi
 *
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    /*** 部署文件后缀名 ***/
    private static final String FILENAME_SUFFIX = ".bpmn20.xml";

    @Autowired
    private UserFlowDao userFlowDao;

    @Autowired
    private DeployDao deployDao;

    @Autowired
    private FormDao formDao;

    @Autowired
    CirculationServiceImpl circulationServiceImpl;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FlowHistoryDao flowHistoryDao;

    /*** 部署文件路径 ***/
    private static final String FILEPATH = ".\\src\\main\\webapp\\processes\\";

    /**
     * 申请流程
     */
    @Override
    @DS("datasource1")
    @Transactional(rollbackFor = Exception.class)
    public void apply(Long flowId, Integer formId) {
        // 流程Id
        Long businessKey = new Date().getTime();
        // 用户名称
        String username = SessionUtil.get().getUserName();
        // 获取流转DTO
        CirculationDTO circulation = circulationServiceImpl.getCirculationDTO(formId);
        /** 部署流程 **/
        FlowDTO flow = deployDao.getFlow(flowId);
        String processkey = flow.getProcesskey();
        // 根据bpmn文件部署流程
        // repositoryService.createDeployment().addClasspathResource("\\processes\\" + processkey +
        // FILENAME_SUFFIX).deploy();
        try {
            File file = Paths.get(FILEPATH + processkey + FILENAME_SUFFIX).toFile();
            InputStream inputStream = new FileInputStream(file);
            repositoryService.createDeployment().addInputStream(processkey + FILENAME_SUFFIX, inputStream).deploy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 获取开始节点
        FlowNode startNode = circulationServiceImpl.getStartNode(flow);
        // 获取用户任务
        List<FlowNode> userFlowNode = circulationServiceImpl.getNextNode(flow, startNode, circulation);

        // 流程变量赋值
        Map<String, Object> variables = circulationServiceImpl.convertObjectToMap(circulation);
        // 设置受理人变量
        String key = "user" + userFlowNode.get(0).getNodeId();
        variables.put(key, username);
        // 采用key来启动流程定义并设置流程变量，返回流程实例
        runtimeService.startProcessInstanceByKey("myProcess" + processkey, businessKey.toString(), variables);
        // 注意 这里需要拿登录用户来查询，key-value需要拿value来获取任务
        List<Task> list = taskService.createTaskQuery().taskAssignee(username).list();

        // 审批历史
        FlowHistory history = new FlowHistory();
        history.setBusinessKey(Long.valueOf(businessKey));
        history.setTaskName(userFlowNode.get(0).getNodeName());
        history.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        history.setOperateDepartment(SessionUtil.get().getMainDepartName());
        history.setOperator(SessionUtil.get().getUserName());
        flowHistoryDao.insert(history);

        for (FlowNode userNode : userFlowNode) {
            // 获取用户任务之后的下一个用户任务
            List<FlowNode> nextNodeList = circulationServiceImpl.getNextNode(flow, userNode, circulation);
            for (FlowNode nextNode : nextNodeList) {
                // 获取下一节点参与者姓名
                Integer participant = nextNode.getParticipant();
                User participantUser = circulationServiceImpl.getParticipantUser(participant);
                String participantUserName = participantUser.getUserName();
                // 流程变量代理人赋值
                String userKey = "user" + nextNode.getNodeId();
                variables.put(userKey, participantUserName);

                // 获取下一个用户任务节点
                List<FlowNode> nextNextNodeList = circulationServiceImpl.getNextNode(flow, nextNode, circulation);
                List<Long> nodeList = nextNextNodeList.stream().map(FlowNode -> FlowNode.getNodeId()).collect(Collectors.toList());
                String strNodeList = DeserializationConverter.listToJson(nodeList);
                Long userId = SessionUtil.get().getUserId();
                UserFlow userFlow = new UserFlow();
                userFlow.setUserId(userId);
                userFlow.setParticipantUserId(participantUser.getUserId());
                userFlow.setBusinessKey(businessKey);
                userFlow.setFormId(formId);
                userFlow.setFlowId(flowId);
                userFlow.setNextNodeId(strNodeList);
                userFlowDao.insert(userFlow);
            }
        }
        // 完成用户任务
        taskService.complete(list.get(0).getId(), variables);
    }

    /**
     * 流程审批功能
     */
    @Override
    @DS
    @Transactional(rollbackFor = Exception.class)
    public void examine(ExamineDTO examine) {
        // 任务Id
        String taskId = examine.getTaskId();
        /** 同意 0 驳回 1 **/
        Integer examineType = examine.getExamineType();
        // 批注信息
        String comment = examine.getComment();
        if (comment == null || "".equals(comment)) {
            // 如果批注信息是空的话 设置默认
            if (examineType.equals(1)) {
                comment = "驳回";
            } else if (examineType.equals(0)) {
                comment = "同意";
            }
        }
        // 获取流程实例id
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        // 通过流程实例id获取流程实例对象，从而获取businessKey
        String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getBusinessKey();
        // 获取当前用户的UserId
        Long userId = SessionUtil.get().getUserId();
        Map<String, Object> userFlowMap = new HashMap<String, Object>();
        userFlowMap.put("businessKey", Long.valueOf(businessKey));
        userFlowMap.put("participantUserId", userId);

        // 审批历史
        FlowHistory history = new FlowHistory();
        history.setBusinessKey(Long.valueOf(businessKey));
        history.setTaskName(examine.getTaskName());
        history.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        history.setOperateDepartment(SessionUtil.get().getMainDepartName());
        history.setOperator(SessionUtil.get().getUserName());
        history.setComment(comment);
        flowHistoryDao.insert(history);
        // 获取当前用户的userFlow
        UserFlow userFlow = circulationServiceImpl.getUserFlow(userFlowMap);

        /** 如果是驳回 **/
        if (examineType.equals(1)) {
            // 添加批注信息
            taskService.addComment(taskId, processInstanceId, comment);
            // 删除流程
            runtimeService.deleteProcessInstance(processInstanceId, "流程驳回");
            // 设置流程的状态为驳回
            /** status 1审批中 2 已经审批 3 驳回 **/
            formDao.updateStatus(userFlow.getFormId(), 3);
            // 审批结束
            return;
        }
        /** 同意操作 **/
        // 添加批注信息
        taskService.addComment(taskId, processInstanceId, comment);

        // 获取下一节点的受理人
        String nextNodeIds = userFlow.getNextNodeId();

        // 设置流转DTO
        Integer formId = userFlow.getFormId();
        CirculationDTO circulation = circulationServiceImpl.getCirculationDTO(formId);

        Map<String, Object> variables = new HashMap<String, Object>();

        // 设置下一节点受理人变量
        if (nextNodeIds != null && !"".equals(nextNodeIds)) {
            List<Long> nextNodeList = DeserializationConverter.jsonToList(nextNodeIds, Long.class);
            for (Long nextNodeId : nextNodeList) {
                // 获取下一个节点
                FlowDTO flow = deployDao.getFlow(userFlow.getFlowId());
                Map<Long, FlowNode> nodesMap = circulationServiceImpl.nodesMap(flow);
                FlowNode flowNode = nodesMap.get(nextNodeId);

                // 参与者的岗位
                Integer participant = flowNode.getParticipant();
                // 指定下一个任务的办理人
                User participantUser = circulationServiceImpl.getParticipantUser(participant);
                String participantUserName = participantUser.getUserName();
                String key = "user" + flowNode.getNodeId();
                variables.put(key, participantUserName);
                taskService.setVariables(taskId, variables);

                // 获取下一个用户任务节点
                List<FlowNode> nextNextNodeList = circulationServiceImpl.getNextNode(flow, flowNode, circulation);

                Map<String, Object> updateMap = new HashMap<String, Object>();
                updateMap.put("currentUserId", userId);
                if (nextNextNodeList != null && nextNextNodeList.size() > 0) {
                    List<Long> nodeList = nextNextNodeList.stream().map(FlowNode -> FlowNode.getNodeId()).collect(Collectors.toList());
                    String strNodeList = DeserializationConverter.listToJson(nodeList);
                    userFlowDao.delete(userFlow);
                    // 写入用户流程表中
                    UserFlow userFlowInsert = new UserFlow();
                    userFlowInsert.setUserId(userFlow.getUserId());
                    userFlowInsert.setParticipantUserId(participantUser.getUserId());
                    userFlowInsert.setBusinessKey(Long.valueOf(businessKey));
                    userFlowInsert.setNextNodeId(strNodeList);
                    userFlowInsert.setFormId(formId);
                    userFlowInsert.setFlowId(userFlow.getFlowId());
                    userFlowDao.insert(userFlowInsert);
                } else {
                    // 写入用户流程表中
                    userFlowDao.delete(userFlow);
                    UserFlow userFlowInsert = new UserFlow();
                    userFlowInsert.setUserId(userFlow.getUserId());
                    userFlowInsert.setParticipantUserId(null);
                    userFlowInsert.setBusinessKey(Long.valueOf(businessKey));
                    userFlowInsert.setNextNodeId(null);
                    userFlowInsert.setFormId(formId);
                    userFlowInsert.setFlowId(userFlow.getFlowId());
                    userFlowDao.insert(userFlowInsert);
                }
            }
        }

        // 完成任务
        taskService.complete(taskId);

        // 判断流程是否结束
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)// 使用流程实例ID查询
                .singleResult();
        if (null == pi) {
            // 更新请假单状态
            // 设置流程的状态为驳回
            /** status 1审批中 2 已经审批 3 驳回 **/
            System.out.println("流程结束");
            Long currentFormId = userFlowDao.getFormId(Long.valueOf(businessKey));
            formDao.updateStatus(currentFormId.intValue(), 2);
        }
    }

    /**
     * 设置审批界面
     */
    @Override
    @DS
    public ExamineResultDTO toExamine(String taskId) {
        // 获取流程实例id
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        // 通过流程实例id获取流程实例对象，从而获取businessKey
        String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getBusinessKey();
        // 获取当前用户的UserId
        Long userId = SessionUtil.get().getUserId();
        Map<String, Object> userFlowMap = new HashMap<String, Object>();
        userFlowMap.put("businessKey", Long.valueOf(businessKey));
        userFlowMap.put("participantUserId", userId);
        // 获取用户userFlow
        UserFlow userFlow = circulationServiceImpl.getUserFlow(userFlowMap);
        ExamineResultDTO form = deployDao.getFormByFormId(userFlow.getFormId());
        List<FlowHistory> historyList = flowHistoryDao.listByKey(Long.valueOf(businessKey));
        form.setHistoryList(historyList);
        return form;
    }

    /**
     * 用户待审批流程
     */
    @Override
    @DS
    public List<WorkFlowDTO> findTaskListByName(String name) {
        name = SessionUtil.get().getUserName();
        List<Task> list = taskService.createTaskQuery().taskAssignee(name).orderByTaskCreateTime().asc().list();
        List<WorkFlowDTO> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (org.activiti.engine.task.Task task : list) {
                // 通过流程实例id获取流程实例对象，从而获取businessKey
                String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey();

                Long userId = SessionUtil.get().getUserId();
                Map<String, Object> userFlowMap = new HashMap<String, Object>();
                userFlowMap.put("businessKey", Long.valueOf(businessKey));
                userFlowMap.put("participantUserId", userId);
                // 查询出申请单据
                WorkFlowDTO flowDTO = new WorkFlowDTO();
                flowDTO.setTaskId(task.getId());
                flowDTO.setApprover(task.getAssignee());
                flowDTO.setTaskName(task.getName());
                flowDTO.setTaskCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getCreateTime()));
                flowDTO.setBusinessKey(businessKey);
                // flowDTO.setFlowId(task.getProcessInstanceId());
                UserFlow userFlow = circulationServiceImpl.getUserFlow(userFlowMap);
                ExamineResultDTO form = deployDao.getFormByFormId(userFlow.getFormId());
                BeanUtils.copyProperties(form, flowDTO);
                resultList.add(flowDTO);
            }
        }
        return resultList;
    }

    @Override
    @DS
    public List<FlowHistory> listFlowHistory(UserFlow userFlow) {

        UserFlow userflow = userFlowDao.getUserFlowBusinesKey(userFlow);
        Long businessKey = userflow.getBusinessKey();
        List<FlowHistory> flowHistories = flowHistoryDao.listByKey(businessKey);

        return flowHistories;
    }
}
