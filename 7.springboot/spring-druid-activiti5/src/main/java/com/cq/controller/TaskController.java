package com.cq.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.dto.TaskDTO;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	/**
	 * 查询当前人的个人任务
	 * 
	 * @param assignee 当前办理人姓名
	 * @return
	 */
	@RequestMapping(value = "/findpersonaltask", method = RequestMethod.GET)
	public List<TaskDTO> findPersonalTask(String assignee) {
		//创建任务查询对象
		TaskQuery tq = taskService.createTaskQuery();
		//指定任务的办理人
		tq.taskAssignee(assignee);
		//返回个人任务集合
		List<Task> tl = tq.list();
		List<TaskDTO> taskList = new ArrayList<TaskDTO>(10);
		for (Task t : tl) {
			taskList.add(new TaskDTO(t));
		}
		return taskList;
	}
	
	/**
	 * 处理当前人任务
	 * @param taskId 任务ID
	 */
	@RequestMapping(value = "/finishtask", method = RequestMethod.GET)
	public String finishTask(String taskId) {
		taskService.complete(taskId);
		return "完成任务：任务ID为：" + taskId;
	}
}
