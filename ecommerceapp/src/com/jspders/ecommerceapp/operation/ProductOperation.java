package com.jspders.ecommerceapp.operation;

import java.util.Scanner;
import java.util.List;

import com.jspders.ecommerceapp.collection.ProductCollection;
import com.jspders.ecommerceapp.entity.Product;

public class ProductOperation {
	private static ProductCollection productCollection = new ProductCollection();
	
	public void addProduct(Scanner scanner) {
		System.out.println("Enter Product id");
		int id =scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter product title");
		String title =scanner.nextLine();
		System.out.println("Enter product description");
		String description =scanner.nextLine();
		System.out.println("Enter product price");
		double price = scanner.nextDouble();
		Product product = new Product(id, title, description, price, false);
		List<Product> products = productCollection.getProducts();
		products.add(product);
		System.out.println("Product added");	
	}
	
	public void findProductById(Scanner scanner) {
		System.out.println("Enter product id");
		int id=scanner.nextInt();
		List<Product> products =productCollection.getProducts();
		Product productById =null;
		for (Product product : products) {
			if (product.getId() == id) {
				productById = product;
				break;
			}
		}
		if(productById != null) {
			System.out.println(productById);
		}else {
			System.out.println("Product not found");
		}
		
		
		
		
	}

}
