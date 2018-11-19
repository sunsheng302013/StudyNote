package com.cq.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.dto.DeploymentDTO;
import com.cq.service.DeploymentService;

@Service
public class DeploymentServiceImpl implements DeploymentService {

	 @Autowired
	 RepositoryService repositoryService;

	 @Override
		public DeploymentDTO createOne(String processResource) {
			//创建一个部署对象
			DeploymentBuilder db = repositoryService.createDeployment();
			//从classpath加载文件，一次只能加载一个，默认resources目录
			db.addClasspathResource(processResource);
			//添加部署的名称
			db.name("员工请假");
			//完成部署,生成部署对象
			Deployment dep = db.deploy();
			
			return new DeploymentDTO(dep);
		}
	 
	    @Override
	    public Object getOne(String id) {
	        Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(id).singleResult();
	        return new DeploymentDTO(deployment);
	    }


	    @Override
	    public void deleteOne(String id) {
	        repositoryService.deleteDeployment(id);
	    }

	    @Override
	    public Object postOne(Deployment entity) {
	        return null;
	    }

	    @Override
	    public Object putOne(String s, Deployment entity) {
	        return null;
	    }

	    @Override
	    public Object patchOne(String s, Deployment entity) {
	        return null;
	    }
}
