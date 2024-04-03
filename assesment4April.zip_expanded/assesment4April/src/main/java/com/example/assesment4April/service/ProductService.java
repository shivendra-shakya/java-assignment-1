package com.example.assesment4April.service;

import java.util.List;
import java.util.Map;

import com.example.assesment4April.model.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public List<Product> getProducts();
	public Map<String, Double> generateBill();
	boolean deleteProduct(int productId);
}
