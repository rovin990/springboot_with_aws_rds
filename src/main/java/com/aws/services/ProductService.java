package com.aws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.entities.Product;
import com.aws.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void upsert(Product product ) {
		productRepository.save(product);
	}
	
	public Product getProductById(long pid) {
		
		Optional<Product> findById = productRepository.findById(pid);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}
	
	public List<Product >getAllProducts() {
		return productRepository.findAll();
	}
	
	public void deleteById(long pid) {
		if(productRepository.existsById(pid)) {
			productRepository.deleteById(pid);
		}
	}

}
