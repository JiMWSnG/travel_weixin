package com.travel.dao;

import com.travel.bean.Contact;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public interface ContactDao {
    /**
     * 添加订单联系人
     * @param contact
     * @return 订单id 号
     */
    int addContact(Contact contact);
}
