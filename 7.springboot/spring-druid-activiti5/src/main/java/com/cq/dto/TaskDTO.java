package com.cq.dto;

import java.util.Date;

import org.activiti.engine.task.Task;

public class TaskDTO {

	/** 任务ID **/
	private String id;
	
	/** 任务名称 **/
	private String name;
	
	/** 任务创建时间 **/
	private Date createTime;
	
	/** 任务办理人 **/
	private String assignee;
	
	/** 流程实例ID **/
	private String processDefinitionId;
	
	/** 执行对象ID **/
	private String executionId;

	public TaskDTO(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.createTime = task.getCreateTime();
		this.assignee = task.getAssignee();
		this.processDefinitionId = task.getProcessDefinitionId();
		this.executionId = task.getExecutionId();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
}
