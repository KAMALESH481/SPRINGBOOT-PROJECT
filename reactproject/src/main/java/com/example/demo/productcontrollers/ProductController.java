package com.example.demo.productcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product.product;
import com.example.demo.productrepository.ProductRepository;
import com.example.demo.productservice.ApiService;
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	ProductRepository serviceRepository;
	@Autowired
	ApiService service;
	
	@GetMapping("/employees")
	List<product> getList()
	{
		return serviceRepository.findAll();
	}
	@GetMapping("/employees/{id}")
	public Optional<product> getById(@PathVariable int id)
	{
		return service.getById(id);
	}	
	@PostMapping("/employees")
	public product create(@RequestBody product stut)
	{
		return serviceRepository.save(stut);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<product> updateGame(@PathVariable int id, @RequestBody product gsm){
		product game = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Game does not exist with id :" + id));
		
		game.setName(gsm.getName());
		game.setProduct(gsm.getProduct());
		game.setQuantity(gsm.getQuantity());
		product updatedGame = serviceRepository.save(game);
		return ResponseEntity.ok(updatedGame);
	}
	
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int id)
	{
		return service.deleteDetails(id);
	}

}
