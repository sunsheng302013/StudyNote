/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.DepartPositionDao;
import com.cq.model.DepartPosition;
import com.cq.service.DepartPositionService;

/**
 * @since 2018年8月28日 下午6:41:31
 * @author chengq
 *
 */
@Service
public class DepartPositionServiceImpl implements DepartPositionService {

    @Autowired
    DepartPositionDao departPositionDao;

    @Override
    @DS
    public List<DepartPosition> getPosition() {
        return departPositionDao.selectAllPosition();
    }
}
