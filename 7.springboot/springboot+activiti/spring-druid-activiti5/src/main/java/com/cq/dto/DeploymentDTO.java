package com.cq.dto;

import java.io.Serializable;
import java.util.Date;

import org.activiti.engine.repository.Deployment;

public class DeploymentDTO implements Serializable{

	private static final long serialVersionUID = 2972344958577211640L;
	
	private String id;
	private String name;
	private Date deploymentTime;
	private String category;
	private String tenantId;
	
	public DeploymentDTO() {}
	
	public DeploymentDTO(Deployment deployment) {
		this.id = deployment.getId();
		this.name = deployment.getName();
		this.deploymentTime = deployment.getDeploymentTime();
		this.category = deployment.getCategory();
		this.tenantId = deployment.getTenantId();
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
	public Date getDeploymentTime() {
		return deploymentTime;
	}
	public void setDeploymentTime(Date deploymentTime) {
		this.deploymentTime = deploymentTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
}
