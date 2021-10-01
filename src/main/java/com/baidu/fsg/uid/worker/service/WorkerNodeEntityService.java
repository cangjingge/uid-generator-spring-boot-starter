package com.baidu.fsg.uid.worker.service;


import com.baidu.fsg.uid.worker.entity.WorkerNodeEntity;

/**
 * <p>
 * 数据库操作解耦 接口
 * </p>
 *
 * @author jason
 * @since 2021-10-1
 */
public interface WorkerNodeEntityService {

    /**
     * 保存实体
     *
     * @param workerNodeEntity
     */
    Long save(WorkerNodeEntity workerNodeEntity);
}
