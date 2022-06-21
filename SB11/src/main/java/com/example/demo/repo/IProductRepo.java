package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.Product;

public interface IProductRepo extends JpaRepository<Product, Integer>
{
	//List<Product>findByPrdtname(String name);					//Custom queries
	//List<Product>findByprdtpriceBetween(float lower, float higher);
	
	@Query("from Product where prdtname=:prdtName")              //Declared queries
	List<Product>getProductWithName(@Param("prdtName")String name);
	@Query("from Product where prdtprice>=:lower and prdtprice<=:higher")
	List<Product>getProductWithPrice(@Param("lower")Float lower, @Param("higher")Float higher);
	
}


