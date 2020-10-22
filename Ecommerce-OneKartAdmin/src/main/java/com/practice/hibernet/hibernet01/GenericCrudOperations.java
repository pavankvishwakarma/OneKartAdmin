package com.practice.hibernet.hibernet01;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;
public class GenericCrudOperations {

	public static void createProduct(Product object,Session session ,int catId) {
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

	public static Product readProduct(int ProductId,Session session ) {
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

			System.out.println("Done!");
			return p;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public static void updateProductName(int ProductId,Session session,String newName ) {
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
	public static void updateProductPrice(int ProductId,Session session,int newPrice ) {
		try {	
			session=getNewSession();
			System.out.println("Updating product name");

			session.beginTransaction();

			Product product = session.get(Product.class, ProductId);
			product.setPrice(newPrice);

			session.getTransaction().commit();
			System.out.println("Done!");

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void updateProductSize(int ProductId,Session session,String newSize ) {
		try {		
			session=getNewSession();
			System.out.println("Updating product name");

			session.beginTransaction();

			Product product = session.get(Product.class, ProductId);
			product.setSize(newSize);

			session.getTransaction().commit();
			System.out.println("Done!");

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void deleteProduct(int ProductId,Session session ) {
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

	public static void createCategory(Category object,Session session ) {
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
//check on this
	public static Category readCategory(int categoryId,Session session ) {
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

			System.out.println("Done!");
			return p;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public static void updateCategoryName(int categoryId,Session session,String newName ) {
		try {	
			session=getNewSession();
			System.out.println("Updating product name");

			session.beginTransaction();

			Category category = session.get(Category.class, categoryId);
			category.setCategoryName(newName);

			session.getTransaction().commit();
			System.out.println("Done!");

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void deleteCategory(int categoryId,Session session ) {
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

	public static List<Product> getProductList(int categoryId,Session session ){
		List<Product> list=null;
		try {			

			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			list = session.get(Category.class, categoryId).getProducts();

			System.out.println("the list is "+list);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
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
	public static List<Product> getCategoryList(Session session ){
		List<Product> list=null;
		try {			
			session=getNewSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("deleting the category...");
			list = session.createQuery("from Category").list();

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
