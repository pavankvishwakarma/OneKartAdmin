package com.practice.hibernet.hibernet01;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;

public class MyApp {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Category.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		Scanner s = new Scanner(System.in);
		int choice=0;
		try {
			do {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=========Welcome to GenKart Ecommerce!!======");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("List of categories Found!!");
			System.out.println(GenericCrudOperations.getCategoryList(session));
			//print of categories

			System.out.println("select your operation on Category\n 1)Add\n 2)Delete\n 3)Update Name\n 4)List\n 5)Exit");
			int listOptionId= Integer.parseInt(s.nextLine());
			if(listOptionId==1) {
				System.out.println("Adding new Category");
				System.out.println("Enter the new Category name");
				String newCategory = s.nextLine();
				GenericCrudOperations.createCategory(new Category(newCategory), session);
			}else if(listOptionId==2) {
				System.out.println("Select the Category id you want to delete");
				System.out.println(GenericCrudOperations.getCategoryList( session));
				int cid=Integer.parseInt(s.nextLine());
				GenericCrudOperations.deleteCategory(cid, session);
			}else if(listOptionId==3) {
				System.out.println("Select the Category id you want to update");
				System.out.println(GenericCrudOperations.getCategoryList( session));
				int cid=Integer.parseInt(s.nextLine());
				System.out.println("Enter the new name for the category");
				String newName= s.nextLine();
				GenericCrudOperations.updateCategoryName(cid, session, newName);
			}else if(listOptionId==4) {
				System.out.println("Select the Category id you want to see products");
				System.out.println(GenericCrudOperations.getCategoryList( session));
				int cid=Integer.parseInt(s.nextLine());
				System.out.println("Below are the list of products in your category");
				System.out.println(GenericCrudOperations.getProductList(cid, session));
				//print product
				System.out.println("Select your option on product\n 1)Add\n 2)delete\n 3)Update Attribute\n 4)Exit");
				int opid=Integer.parseInt(s.nextLine());
				if(opid==1) {
					System.out.println("Add a new product in category "+GenericCrudOperations.readCategory(cid, session));
					System.out.println("Enter new Product details");
					System.out.println("Enter product name");
					String pname=s.nextLine();
					System.out.println("Enter product price");
					int price= Integer.parseInt(s.nextLine());
					System.out.println("Enter product size");
					String size=s.nextLine();
					GenericCrudOperations.createProduct(new Product(pname,price,size), session, cid);
				}else if(opid==2) {
					System.out.println("Below are the list of products in your category");
					System.out.println(GenericCrudOperations.getProductList(cid, session));
					System.out.println("Select your product to delete");
					int pdId=Integer.parseInt(s.nextLine());
					GenericCrudOperations.deleteProduct(pdId, session);
				}else if(opid==3) {
					System.out.println("Below are the list of products in your category");
					System.out.println(GenericCrudOperations.getProductList(cid, session));
					System.out.println("Select your product to update");
					int pdId=Integer.parseInt(s.nextLine());
					System.out.println("Enter the new name for the product");
					String newName =s.nextLine();
					GenericCrudOperations.updateProductName(pdId, session, newName);
				}else if(opid==4) {
					System.exit(0);
				}
			}else {
				System.exit(0);
			}
			System.out.println("Do you want to Repeat? \n1) Yes \n2) No");
			choice=Integer.parseInt(s.nextLine());
			if(choice!=1) {
				break;
			}
			}while(choice==1);
		}finally {
			factory.close();
		}
	}

}
