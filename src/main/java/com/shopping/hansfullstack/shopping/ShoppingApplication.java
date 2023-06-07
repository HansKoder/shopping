package com.shopping.hansfullstack.shopping;

import com.shopping.hansfullstack.shopping.random.PopulateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication implements CommandLineRunner {

	@Autowired
	private PopulateData populateData;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("running...");
		populateData.populateClothes();
		populateData.populateSuppliers();
	}
}
