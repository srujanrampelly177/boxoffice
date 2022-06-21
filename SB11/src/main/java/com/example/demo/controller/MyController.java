package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Product;
import com.example.demo.service.IProductService;

@Controller
//@RequestMapping(path = "/api")  // for this we should give ----  http://localhost:8082/v2/api-docs 	(or)   	http://localhost:8082/api/products   
public class MyController 
{
	@Autowired				   //for this all we should give ----- http://localhost:8082/v2/api-docs   (or)   http://localhost:8082/products
	IProductService service;
	@RequestMapping(path = "/products")
	public String getAllproducts(Model model)						//Handler methods
	{
		model.addAttribute("prdtlist", service.getAllProducts());
		return "ShowAllProducts";
	}
	@GetMapping(path = "/showProductForm")
	public String showAddForm(Model model)
	{
		Product prdt = new Product();
		model.addAttribute("prdt", prdt);
		return "AddForm";
	}
	@GetMapping(path = "/searchForm")
	public String searchOne(Model model) 
	{
		Product prdt = new Product();
		model.addAttribute("prdt", prdt);
		return "SearchOne";
	}
	@GetMapping(path = "/updateForm")
	public String showUpdateForm(Model model)
	{
		Product prdt = new Product();
		model.addAttribute("prdt", prdt);
		return "UpdateForm";
	}
	@GetMapping(path = "/delteProduct")
	public String deleteproduct(Model model)
	{
		Product prdt = new Product();
		model.addAttribute("prdt", prdt);
		return "Delete";
	}
		
	/*@GetMapping(path = "/product/{id}")
	public Product getProductWithId(@PathVariable Integer id)
	{
		return service.getProductWithId(id).get();
	}*/
	@GetMapping(path = "/productid")
	public String searchProduct(@ModelAttribute("prdt") int prdtid)
	{
		service.getProductWithId(prdtid);
		return "redirect:/products";
	}
	
	@GetMapping(path = "/productbyname/{name}")                   //Custom queries   //Declared queries
	public List<Product> getProductWithName(@PathVariable String name)
	{
		return service.getProductWithName(name);
	}
	
	@GetMapping(path = "/productbyprice/{lower}/{higher}")                   //Custom queries      //Declared queries
	public List<Product> getProductWithPrice(@PathVariable float lower, @PathVariable float higher)
	{
		return service.getProductWithprice(lower, higher);
	}
	
	
	@PostMapping(path = "/product")
	public String addProduct(@ModelAttribute("prdt") Product prdt)
	{
		service.addProduct(prdt);
		return "redirect:/products";
	}
	/*@PutMapping(path = "/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product prdt)
	{
		ResponseEntity<Product> rs = new ResponseEntity<Product>(service.editProduct(prdt),HttpStatus.ACCEPTED);
		return rs;
	}*/
	@PutMapping(path = "/product")
	public String updateProduct(@ModelAttribute("prdt") Product prdt)
	{
		service.editProduct(prdt);
		return "redirect:/products";
	}
	@DeleteMapping(path = "/productid")   //    /product/{prdtid}
	public String/*ResponseEntity<String>*/ deleteProduct(@RequestParam int prdtid)  //(@PathVariable int prdtid)
	{
		service.deleteProduct(prdtid);
		return "redirect:/products";
		/*ResponseEntity<String> rs = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		return rs;*/
	}
	
}
