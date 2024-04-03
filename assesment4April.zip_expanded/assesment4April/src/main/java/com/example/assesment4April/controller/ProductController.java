package com.example.assesment4April.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assesment4April.model.Product;
import com.example.assesment4April.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService ;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getProducts();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/bill")
    public ResponseEntity<Map<String, Double>> generateBill() {
        Map<String, Double> bill = productService.generateBill();
        return ResponseEntity.ok().body(bill);
    }
    
    @DeleteMapping("/delete/{productId}") 
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int productId) {
        boolean deleted = productService.deleteProduct(productId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
