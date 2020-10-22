package com.practice.hibernet.hibernet01.dao;

import java.util.List;

import com.practice.hibernet.hibernet01.entity.Product;

public interface EntityDAO<K,T,Id,Str> {
	//product
	public void create(T obj, Id val);
	
	public void upadate(Id val, Str name);
	
	public void read(Id productId);
	
	public void delete(Id productId);
	
	public List<Product> getList(Id catId);
	//category
	public void create(K catObj);
	
	public void updateCatName(Id catId,Str newCatName);
	
	public List<K> getCategroyList();
	
}
