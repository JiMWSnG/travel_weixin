package com.travel.dao.impl;

import com.travel.bean.RouteDescription;
import com.travel.dao.DescriptionDao;
import com.travel.entity.Description;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jim Wang on 2016/10/13.
 */
public class RouteDescriptionDaoImpl extends SqlSessionDaoSupport implements DescriptionDao{
    //{PropertyConfigurator.configure("src/main/resources/conf/log4j.properties");}
    private static final Logger logger = LoggerFactory.getLogger(RouteDaoImpl.class);

    @Override
    public int addDescription(Description description) {
        logger.info("数据库操作：int addDescription(Description routeDescription)");

        if(!(description instanceof RouteDescription)){
            logger.error("添加description时失败,参数类型错误,{}", description.getClass());

            return -1;
        }

        try {
            int ok = getSqlSession().insert("com.travel.bean.RouteDescription.addRouteDescription",description);
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
    public Description queryDescriptionByProductId(Integer routeId) {
        logger.info("准备通过id:{}查询routeDescription",routeId);
        try{
            Description description = getSqlSession().selectOne("com.travel.bean.RouteDescription.getRouteDescriptionByRouteId", routeId);
            if(description!=null){
                logger.info("通过id:{}查询description成功",routeId);
                return description;
            }
            logger.debug("通过id:{}查询description时未查到数据",routeId);

            return null;
        }catch(Exception e){
           // System.out.println("```````````````````````````````````````");
            logger.error("通过id:{}查询description时失败",routeId);
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
