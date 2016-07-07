package com.travel.dao;

import java.util.List;

import com.travel.bean.Product;

public interface ProductDao {
	public int add(Product product);

	public Product queryById(Integer id);

	public List<Product> query(String type, String location, String indexs);

	public List<Product> queryAll();

	public int update(Product product);

	public int remove(Integer id);
}
