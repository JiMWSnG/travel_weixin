package com.travel.service;

import com.travel.entity.Description;

/**
 * Created by Jim Wang on 2016/10/13.
 */
public interface DescriptionService {
    /**
     * 获取Description
     * @param productId
     * @return Description/null
     */
    public Description getDescriptionByProductId(Integer productId);

    /**
     * 添加Description，Description的主键id
     * @param description
     * @return id>0/-1
     */
    public int addDescription(Description description);
}
