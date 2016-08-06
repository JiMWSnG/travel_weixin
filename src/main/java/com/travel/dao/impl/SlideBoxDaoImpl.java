package com.travel.dao.impl;

import com.travel.bean.SlideBox;
import com.travel.dao.SlideBoxDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jim Wang on 2016/7/25.
 */
public class SlideBoxDaoImpl extends SqlSessionDaoSupport implements SlideBoxDao{
    private static final Logger logger = LoggerFactory.getLogger(HotelDaoImpl.class);

    @Override
    public int addSlideBox(SlideBox slideBox) {
        long currentTime = new Date().getTime()/1000;
        slideBox.setCt(currentTime);
        slideBox.setUt(currentTime);
        try{
            int ok = getSqlSession().insert("com.travel.bean.SlideBox.addSlideBox",slideBox);
            if(ok<=0){
                return -1;
            }
            return ok;
        }catch(Exception e){
            return -1;
        }
    }

    @Override
    public List<SlideBox> queryByPlace(String place, Integer status) {
        logger.info("准备查询SlideBox，查询条件place:{},status:{}",place,status);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("place", place);
        params.put("status", status);
        try{
            List<SlideBox> slideBoxs=getSqlSession().selectList("com.travel.bean.SlideBox.queryByPlace", params);
            if(slideBoxs!=null){
                logger.info("查询SlideBox成功，查询条件place:{},status:{}",place,status);
                return slideBoxs;
            }
            logger.debug("查询SlideBox失败，查询条件place:{},status:{}",place,status);
            return null;
        }catch(Exception e){
            logger.error("查询SlideBox成功，查询条件place:{},status:{}",place,status);
        return null;
    }
    }
}
