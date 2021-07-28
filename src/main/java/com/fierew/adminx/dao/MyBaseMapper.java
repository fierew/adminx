package com.fierew.adminx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入（mysql）
     *
     * @param entityList 数据
     * @return 结果
     */
    Integer insertBatchSomeColumn(List<T> entityList);
}
