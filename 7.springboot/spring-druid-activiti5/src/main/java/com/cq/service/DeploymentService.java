package com.cq.service;

import org.activiti.engine.repository.Deployment;

import com.cq.dto.DeploymentDTO;

public interface DeploymentService {
	
	/**
	 * 创建资源
	 * @return
	 */
	DeploymentDTO createOne(String processResource);
	
	/**
     * 根据id查询资源
     * @param id 资源的唯一标识
     * @return
     */
    Object getOne(String id);

    /**
     * 提交一个资源
     * @param entity 资源实体
     * @return
     */
    Object postOne(Deployment entity);

    /**
     * 提交一个资源，并给出标识
     * @param id 标识
     * @param entity 资源实体
     * @return
     */
    Object putOne(String id, Deployment entity);

    /**
     * 提交一个资源的一部分，不处理null值
     * @param id 标识
     * @param entity 资源实体
     * @return
     */
    Object patchOne(String id, Deployment entity);

    /**
     * 根据id删除一个资源
     * @param id 标识
     * @return
     */
    void deleteOne(String id);
}

