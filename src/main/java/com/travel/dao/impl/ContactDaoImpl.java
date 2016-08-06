package com.travel.dao.impl;

import com.travel.bean.Contact;
import com.travel.dao.ContactDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public class ContactDaoImpl extends SqlSessionDaoSupport implements ContactDao {
    private static final Logger logger = LoggerFactory.getLogger(RouteDaoImpl.class);
    @Override
    public int addContact(Contact contact) {
        try{
            return getSqlSession().insert("com.travel.bean.Contact.addContact",contact);
        }catch(Exception e){
            return -1;
        }

    }
}
