package com.practice.hibernet.hibernet01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;

public class UnitTests {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Category.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			//verify the Category CRUD
			//GenericCrudOperations.createCategory(new Category("HomeAppliance"), session);
			//Category cat=GenericCrudOperations.readCategory(1, session);
			//System.out.println("Found cat "+cat);
			//GenericCrudOperations.updateCategoryName(1, session,"New name");
			//GenericCrudOperations.deleteCategory(6, session);
			
			//verify the Product Crud
			//GenericCrudOperations.createProduct(new Product("Smartphone", 1000, "small"), session);
			/*Product p =GenericCrudOperations.readProduct(10, session);
			System.out.println("Found product "+p);*/
			//GenericCrudOperations.updateProductName(10, session, "charger");
			//GenericCrudOperations.updateProductPrice(10, session, 2000);
			//GenericCrudOperations.updateProductSize(10, session, "big");
			//GenericCrudOperations.deleteProduct(10, session);
			/*Category cat= new Category("Furniture");
			Product p1= new Product("Table",100,"small");
			Product p2= new Product("Chari",100,"big");
			cat.add(p1);
			cat.add(p2);
			session.beginTransaction();
			session.save(cat);
			session.save(p1);
			session.save(p2);
			session.getTransaction().commit();*/
			
			//GenericCrudOperations.createProduct(new Product("speaker",100,"medium"), session, 6);
			GenericCrudOperations.getProductList(6, session);
			
		}finally {
			factory.close();
		}

		/*	try {			
			// create a student object
			System.out.println("Creating new student object...");
			Category category = new Category("Electronics");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the category...");
			session.save(category);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			factory.close();
		}*/
	}

}





