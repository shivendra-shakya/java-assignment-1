package com.example.assesment4April.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.assesment4April.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	   private List<Product> products = new ArrayList<>();

	    @Override
	    public Product addProduct(Product product) {
	        // Assign auto-generated id
	        int newId = products.size() + 1;
	        product.setId(newId);
	        products.add(product);
	        return product;
	    }

	    @Override
	    public List<Product> getProducts() {
	        return products;
	    }

	    @Override
	    public Map<String, Double> generateBill() {
	        double totalPrice = 0;
	        for (Product product : products) {
	            totalPrice += (product.getPrice() * product.getQuantity());
	        }
	        double cgst = totalPrice * 0.09;
	        double gst = totalPrice * 0.09;
	        double finalTotal = totalPrice + cgst + gst;

	        Map<String, Double> bill = new HashMap<>();
	        bill.put("TotalPrice", totalPrice);
	        bill.put("CGST", cgst);
	        bill.put("GST", gst);
	        bill.put("FinalTotal", finalTotal);

	        return bill;
	    }
	    
	    @Override
	    public boolean deleteProduct(int productId) {
	        for (Product product : products) {
	            if (product.getId() == productId) {
	                products.remove(product);
	                return true;
	            }
	        }
	        return false;
	    }

}
