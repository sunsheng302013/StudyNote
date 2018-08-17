package com.cq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.dto.DeploymentDTO;
import com.cq.service.DeploymentService;

@RestController
@RequestMapping("/deployment")
public class DeploymentController {

	@Autowired
	DeploymentService deploymentService;
	
	/**
	 * 创建流程
	 * 
	 * @param processResource BPMN文件路径
	 * @return
	 */
	@RequestMapping(value = "/createdeployment", method = RequestMethod.GET)
	public DeploymentDTO createDeployment(String processResource) {
		return deploymentService.createOne(processResource);
	}
	
}
