package com.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.entities.Product;
import com.aws.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public String upsert(@RequestBody Product product) {
		System.out.println(product);
		productService.upsert(product);
		return "Success !";
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") long pid) {
		return productService.getProductById(pid);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/product/{pid}")
	public String deleteById(@PathVariable long pid) {
		productService.deleteById(pid);
		return "Deleted !";
	}

}
