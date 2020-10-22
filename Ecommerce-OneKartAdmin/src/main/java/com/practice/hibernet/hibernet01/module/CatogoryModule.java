package com.practice.hibernet.hibernet01.module;

import com.google.inject.AbstractModule;
import com.practice.hibernet.hibernet01.dao.CategoryDAOImpl;
import com.practice.hibernet.hibernet01.dao.EntityDAO;

public class CatogoryModule extends AbstractModule{
	@Override
	protected void configure() {
		bind(EntityDAO.class).to(CategoryDAOImpl.class);
	}
}
