package com.practice.hibernet.hibernet01;

import java.util.Scanner;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.practice.hibernet.hibernet01.dao.GenericDAO;
import com.practice.hibernet.hibernet01.entity.Category;
import com.practice.hibernet.hibernet01.entity.Product;
import com.practice.hibernet.hibernet01.module.CatogoryModule;
import com.practice.hibernet.hibernet01.module.ProductModule;

public class OneKartAdmin {
	public static void main(String[] args) {
		Injector cInjector = Guice.createInjector(new CatogoryModule());
		GenericDAO categoryAccessor = cInjector.getInstance(GenericDAO.class);

		Injector pInjector = Guice.createInjector(new ProductModule());
		GenericDAO productAccessor = pInjector.getInstance(GenericDAO.class);

		Scanner s = new Scanner(System.in);
		int choice=0;

		do {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=========Welcome to GenKart Ecommerce!!======");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("List of categories Found!!");
			System.out.println(categoryAccessor.getCategoryList());
			//print of categories

			System.out.println("select your operation on Category\n 1)Add\n 2)Delete\n 3)Update Name\n 4)List\n 5)Exit");
			int listOptionId= Integer.parseInt(s.nextLine());
			if(listOptionId==1) {
				System.out.println("Adding new Category");
				System.out.println("Enter the new Category name");
				String newCategory = s.nextLine();
				categoryAccessor.createCategory(new Category(newCategory));
			}else if(listOptionId==2) {
				System.out.println("Select the Category id you want to delete");
				System.out.println(categoryAccessor.getCategoryList());
				int cid=Integer.parseInt(s.nextLine());
				categoryAccessor.deleteCategory(cid);
			}else if(listOptionId==3) {
				System.out.println("Select the Category id you want to update");
				System.out.println(categoryAccessor.getCategoryList());
				int cid=Integer.parseInt(s.nextLine());
				System.out.println("Enter the new name for the category");
				String newName= s.nextLine();
				categoryAccessor.updateCategory(cid, newName);
			}else if(listOptionId==4) {
				System.out.println("Select the Category id you want to see products");
				System.out.println(categoryAccessor.getCategoryList());
				int cid=Integer.parseInt(s.nextLine());
				System.out.println("Below are the list of products in your category");
				System.out.println(productAccessor.getProductList(cid));
				//print product
				System.out.println("Select your option on product\n 1)Add\n 2)delete\n 3)Update Attribute\n 4)Exit");
				int opid=Integer.parseInt(s.nextLine());
				if(opid==1) {
					System.out.println("Add a new product in category ");categoryAccessor.readCategory(cid);
					System.out.println("Enter new Product details");
					System.out.println("Enter product name");
					String pname=s.nextLine();
					System.out.println("Enter product price");
					int price= Integer.parseInt(s.nextLine());
					System.out.println("Enter product size");
					String size=s.nextLine();
					productAccessor.createProduct(new Product(pname,price,size), cid);
				}else if(opid==2) {
					System.out.println("Below are the list of products in your category");
					//System.out.println(GenericCrudOperations.getProductList(cid, session));
					System.out.println(productAccessor.getProductList(cid));
					System.out.println("Select your product to delete");
					int pdId=Integer.parseInt(s.nextLine());
					productAccessor.deleteCategory(pdId);
				}else if(opid==3) {
					System.out.println("Below are the list of products in your category");
					System.out.println(productAccessor.getProductList(cid));
					System.out.println("Select your product to update");
					int pdId=Integer.parseInt(s.nextLine());
					System.out.println("Enter the new name for the product");
					String newName =s.nextLine();
					productAccessor.updateProduct(pdId,  newName);
				}else if(opid==4) {
					System.exit(0);
				}
			}else {
				System.exit(0);
			}
			System.out.println("Do you want to Repeat? \n1) Yes \n2) No");
			choice=Integer.parseInt(s.nextLine());
			if(choice!=1) {
				System.exit(0);
			}
		}while(choice==1);
	}


}
