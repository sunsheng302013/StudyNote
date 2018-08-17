package com.cq.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/runtime")
public class RuntimeController {

	@Autowired
	RuntimeService runtimeService;
	
	/**启动流程实例**/
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public void startProcessInstance(String processKey) {
		//流程定义的key,key对应bpmn文件的id属性(如果不修改id，id属性默认为bpmn文件名)
		//通过key,启动用户实例,返回流程实例对象
		//使用key的优势在于，默认使用最新版本的流程定义启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(processKey);
		pi.getProcessDefinitionId();
	}

}
