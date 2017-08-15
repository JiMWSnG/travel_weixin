package com.travel.dao.impl;

import com.travel.bean.HotelDescription;
import com.travel.bean.RouteDescription;
import com.travel.dao.DescriptionDao;
import com.travel.entity.Description;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jim Wang on 2016/11/22.
 */
public class HotelDescriptionDaoImpl extends SqlSessionDaoSupport implements DescriptionDao{
    //{PropertyConfigurator.configure("src/main/resources/conf/log4j.properties");}
    private static final Logger logger = LoggerFactory.getLogger(RouteDaoImpl.class);

    @Override
    public int addDescription(Description description) {
        logger.info("数据库操作：int addDescription(Description hotelDescription)");

        if(!(description instanceof HotelDescription)){
            logger.error("添加description时失败,参数类型错误,{}", description.getClass());

            return -1;
        }

        try {
            int ok = getSqlSession().insert("com.travel.bean.HotelDescription.addHotelDescription",description);
            if(ok==1){
                logger.info("添加{}成功",description.toString());
                return description.getId();
            }
            logger.debug("添加{}时失败", description.toString());
            return -1;
        } catch (Exception e) {
            logger.error("添加{}时失败,数据库错误", description.toString());
            return -1;

        }
    }

    @Override
    public Description queryDescriptionByProductId(Integer hotelId) {
        logger.info("准备通过id:{}查询routeDescription",hotelId);
        try{
            Description description = getSqlSession().selectOne("com.travel.bean.HotelDescription.getHotelDescriptionByHotelId", hotelId);
            if(description!=null){
                logger.info("通过id:{}查询description成功",hotelId);
                return description;
            }
            logger.debug("通过id:{}查询description时未查到数据",hotelId);

            return null;
        }catch(Exception e){
           // System.out.println("```````````````````````````````````````");
            logger.error("通过id:{}查询description时失败",hotelId);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateDescription(Description description) {
        return 0;
    }

    @Override
    public int removeDescription(Integer id) {
        return 0;
    }
}
