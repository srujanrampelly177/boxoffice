package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.bean.Product;

public interface IProductService 
{
	public Optional<Product>getProductWithId(int prdtid);
	public Product addProduct(Product prdt);
	public void deleteProduct(int prdtid);
	public List<Product> getAllProducts();
	public Product editProduct(Product prdt);
	//public List<Product> getProductWithName(String name);         //Custom queries
	//public List<Product> getProductWithprice(float lower, float higher);
	
	public List<Product> getProductWithName(String name);        //Declared queries
	public List<Product> getProductWithprice(float lower, float higher);
}
