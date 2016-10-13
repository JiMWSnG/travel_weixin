package com.travel.dao;

import com.travel.entity.Description;

import java.util.List;

public interface DescriptionDao {
	/**
	 * 查询Description，返回主键 id
	 * @param description
	 * @return  id>0 /-1
     */
	public int addDescription(Description description);

	/**
	 * 通过产品id获取对应的详细说明Description
	 * @param productId
	 * @return Desciption/null
     */
	public Description queryDescriptionByProductId(Integer productId);

	//public List<Product> query(String category, String location, String indexs);

	//public List<Product> queryAll();

	public int updateDescription(Description description);

	public int removeDescription(Integer id);
}
