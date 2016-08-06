package com.travel.dao;

import com.travel.bean.SlideBox;

import java.util.List;

/**
 * Created by Jim Wang on 2016/7/25.
 */
public interface SlideBoxDao {
    /**
     * 按轮播穿的位置查询
     * @param place 轮播窗的位置
     * @param status 状态：开/关
     * @return
     */
    List<SlideBox> queryByPlace(String place,Integer status);
    int addSlideBox(SlideBox slideBox);

}
