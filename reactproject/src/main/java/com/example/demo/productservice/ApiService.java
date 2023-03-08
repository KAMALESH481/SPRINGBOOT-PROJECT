package com.example.demo.productservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.product.product;
import com.example.demo.productrepository.ProductRepository;
@Service
public class ApiService {
	@Autowired
	ProductRepository repository;
	public String updateDetails(product stu)	
	{
		repository.save(stu);
		return "updated";
	}
	public Optional<product> getById(int id)
	{
		return repository.findById(id);
	}
	public String deleteDetails(int id)
	{
		if(repository.existsById(id)) 
		{
			repository.deleteById(id);
			return "Id deleted";			
		}
		else 
			 return "Id not exist";
	}
}


