package com.practice.hibernet.hibernet01.module;

import com.google.inject.AbstractModule;
import com.practice.hibernet.hibernet01.dao.EntityDAO;
import com.practice.hibernet.hibernet01.dao.ProductDAOImpl;


public class ProductModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(EntityDAO.class).to(ProductDAOImpl.class);
	}

}
