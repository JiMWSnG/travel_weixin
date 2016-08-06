package com.travel.dao;

import java.util.List;

import com.travel.bean.Product;

public interface ProductDao {
	/**
	 * 返回主键 ids
	 * @param product
	 * @return  id>0 /-1
     */
	public int add(Product product);

	public Product queryById(Integer id);

	public List<Product> query(String category, String location, String indexs);

	public List<Product> queryAll();

	public int update(Product product);

	public int remove(Integer id);
}
