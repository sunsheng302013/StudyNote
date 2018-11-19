package com.cq.dao.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.model.file.File;

/**
 *
 * <p>
 * 类描述: 附件信息
 * </p>
 *
 * @since 2018年11月2日
 * @author chengq
 */
@Mapper
public interface FileDao {

    /**
     * 根据userId批量删除附件信息
     *
     * @param userIdList
     *            人员ID
     * @return 删除行数
     */
    Integer deleteBatchByUserId(List<Long> userIdList);

    /**
     * 根据foreignId删除附件信息
     *
     * @param foreignId
     *            外键ID
     * @return 删除行数
     */
    Integer deleteByForeignId(Long foreignId);

    /**
     * 插入附件信息
     *
     * @param fileList
     *            附件信息
     * @return 插入行数
     */
    Integer insert(@Param(value = "fileList") List<File> fileList);
}