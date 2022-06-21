package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.IProductRepo;
@Service
public class ProductServiceimpl implements IProductService 
{
	@Autowired
	IProductRepo repo;
	@Override
	public List<Product> getAllProducts() 
	{
		return repo.findAll();
	}
	@Override
	public Optional<Product> getProductWithId(int prdtid) 
	{
		Optional<Product>optional=repo.findById(prdtid);
		if(optional.isPresent())
			return Optional.ofNullable(optional.get());
		else
			throw new ProductNotFoundException("Product with product id "+prdtid+" is not found");
	}
	@Override
	public Product addProduct(Product prdt)
	{
		return repo.save(prdt);
	}
	@Override
	public Product editProduct(Product prdt)
	{		
		return repo.save(prdt);
	}
	@Override
	public void deleteProduct(int prdtid)
	{
		repo.deleteById(prdtid);;
	}
	/*@Override
	public List<Product> getProductWithName(String name)           //custom queries
	{
		return repo.findByPrdtname(name);
	}
	@Override
	public List<Product> getProductWithprice(float lower, float higher) 
	{
		return repo.findByprdtpriceBetween(lower, higher);
	}*/
	@Override
	public List<Product> getProductWithName(String name)          //Declared queries
	{
		return repo.getProductWithName(name);
	}
	@Override
	public List<Product> getProductWithprice(float lower, float higher) 
	{
		return repo.getProductWithPrice(lower, higher);
	}
	
}
