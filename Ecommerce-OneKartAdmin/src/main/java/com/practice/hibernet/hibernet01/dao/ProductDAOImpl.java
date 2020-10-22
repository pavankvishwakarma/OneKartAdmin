package com.practice.hibernet.hibernet01.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;

public class ProductDAOImpl implements EntityDAO<Category,Product,Integer,String> {

	Session session;
	
	public  Session getNewSession() {
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
	public void create(Product object ,Integer catId) {
	
		try {			
			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			//get category
			Category cat = session.get(Category.class, catId);
			cat.add(object);
			// save the student object
			System.out.println("Saving the product...");
			session.save(object);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void upadate(Integer ProductId, String newName) {
		try {	
			session=getNewSession();
			System.out.println("Updating product name");

			session.beginTransaction();

			Product product = session.get(Product.class, ProductId);
			product.setItemName(newName);

			session.getTransaction().commit();
			System.out.println("Done!");

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	public void read(Integer ProductId) {
		Product p=null;
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the product...");
			p=session.get(Product.class,ProductId);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("The found Product is "+p);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void delete(Integer ProductId) {
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("deleting the product...");
			session.createQuery("delete from Product where id="+ProductId).executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<Product> getList(Integer categoryId) {
		List<Product> list=null;
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			list = session.get(Category.class, categoryId).getProducts();

			//System.out.println("the list is "+list);
			// commit transaction
			session.getTransaction().commit();

			//System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public void create(Category catObj) {
		// TODO Auto-generated method stub
		
	}
	public void updateCatName(Integer catId, String newCatName) {
		// TODO Auto-generated method stub
		
	}
	public List<Category> getCategroyList() {
		// TODO Auto-generated method stub
		return null;
	}


}
