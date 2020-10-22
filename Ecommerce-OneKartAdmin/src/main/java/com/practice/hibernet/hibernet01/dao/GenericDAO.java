package com.practice.hibernet.hibernet01.dao;

import java.util.List;

import com.google.inject.Inject;
import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;


public class GenericDAO {
	private EntityDAO entityDAO;

	@Inject
	public GenericDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}
	//category
	public void createCategory(Category object) {
		entityDAO.create(object);
	}
	public void readCategory(Integer categoryId) {
		entityDAO.read(categoryId);
	}
	public void updateCategory(Integer catId, String newCatName) {
		entityDAO.updateCatName(catId, newCatName);
	}
	public void deleteCategory(Integer categoryId) {
		entityDAO.delete(categoryId);
	}
	public List<Category> getCategoryList() {
		return entityDAO.getCategroyList();
	}
	
	public void createProduct(Product object ,Integer catId) {
		entityDAO.create(object, catId);
	}
	public void readProduct(Integer ProductId) {
		entityDAO.read(ProductId);
	}
	public void updateProduct(Integer ProductId, String newName) {
		entityDAO.upadate(ProductId, newName);;
	}
	public void deleteProduct(Integer ProductId) {
		entityDAO.delete(ProductId);
	}
	public List<Category> getProductList(Integer categoryId) {
		return entityDAO.getList(categoryId);
	}

}
