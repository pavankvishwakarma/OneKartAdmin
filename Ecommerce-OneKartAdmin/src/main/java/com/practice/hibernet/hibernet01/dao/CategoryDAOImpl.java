package com.practice.hibernet.hibernet01.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;

public class CategoryDAOImpl implements EntityDAO<Category, Product, Integer, String> {

	Session session;
	
	public static Session getNewSession() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Category.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		// start a transaction
		session.beginTransaction();
		return session;
	}
	
	public void create(Product obj, Integer val) {
		// TODO Auto-generated method stub
		
	}

	public void upadate(Integer val, String name) {
		// TODO Auto-generated method stub
		
	}

	public void read(Integer categoryId) {
		Category p=null;
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the product...");
			p=session.get(Category.class,categoryId);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("The found Catogory is "+p);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void delete(Integer categoryId) {
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("deleting the category...");
			session.createQuery("delete from Category where id="+categoryId).executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Product> getList(Integer catId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Category object) {
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(object);

			// commit transaction
			session.getTransaction().commit();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateCatName(Integer catId, String newCatName) {
		try {	
			session=getNewSession();
			System.out.println("Updating product name");

			session.beginTransaction();

			Category category = session.get(Category.class, catId);
			category.setCategoryName(newCatName);

			session.getTransaction().commit();
			System.out.println("Done!");

		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	public List<Category> getCategroyList() {
		List<Category> list=null;
		try {			
			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
		
			list = session.createQuery("from Category").list();

			// commit transaction
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
