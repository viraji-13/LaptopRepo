package com.deploy.laptop.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deploy.laptop.dto.LaptopDto;
import com.deploy.laptop.entity.Laptop;

@Component
public interface IService {

	public Laptop addLaptop(LaptopDto ldto);
	public List<Laptop> getAllLaptop();
	public Laptop getById(int id);
	public Laptop updateLaptop(LaptopDto ldto , int id);
	public Laptop deleLaptop(int id);
	
}
