package com.baidu.fsg.uid.dao.mapper;

import com.baidu.fsg.uid.dao.entity.WorkerNode;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyr
 * @since 2020-10-26
 */
public interface WorkerNodeDao {

    /**
     * 保存实体
     *
     * @param workerNodeEntity
     */
    Long save(WorkerNode workerNodeEntity);
}
