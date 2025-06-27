package com.deploy.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deploy.laptop.dto.LaptopDto;
import com.deploy.laptop.entity.Laptop;
import com.deploy.laptop.service.SeriveImpl;

import jakarta.validation.Valid;

@RestController
public class Controller {

	@Autowired
	SeriveImpl si;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Laptop>> getAllLaptop(){
		return new ResponseEntity<List<Laptop>>(si.getAllLaptop(), HttpStatus.OK);
	}
	
	@GetMapping("/UserId/{id}")
	public ResponseEntity<List<Laptop>> getByUserId(@PathVariable int id){
		return new ResponseEntity<List<Laptop>>(si.getByUserId(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@Cacheable(value = "Laptops", key ="#id")
	public ResponseEntity<Laptop> getById(@PathVariable int id){
		return new ResponseEntity<Laptop>(si.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	@CachePut(value = "laptops" , key ="id" )
	public ResponseEntity<Laptop> update(@PathVariable int id , @Valid @RequestBody LaptopDto ldto){
		return new ResponseEntity<Laptop>(si.updateLaptop(ldto, id), HttpStatus.OK);	
	} 
	
	@PostMapping("/add")
	public ResponseEntity<Laptop> addLaptop(@Valid @RequestBody  LaptopDto ldto){
		return new ResponseEntity<Laptop>(si.addLaptop(ldto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Laptop> deleteLaptop(@PathVariable int id){
		return new ResponseEntity<Laptop>(si.deleLaptop(id), HttpStatus.OK);
		
	
		
	}
	
}
