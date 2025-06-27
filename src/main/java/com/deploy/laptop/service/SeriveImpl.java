package com.deploy.laptop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deploy.laptop.dto.LaptopDto;
import com.deploy.laptop.entity.Laptop;
import com.deploy.laptop.exception.InvalidLaptopException;
import com.deploy.laptop.repo.LaptopRepo;

@Service
public class SeriveImpl implements IService {

@Autowired
LaptopRepo lr;
	
	@Override
	public Laptop addLaptop(LaptopDto ldto) {
		Laptop l = new Laptop(ldto.getBrand(), ldto.getPrice(), ldto.getUserId());
		lr.save(l);
		return l;
	}

	@Override
	public List<Laptop> getAllLaptop() {
		// TODO Auto-generated method stub
		return lr.findAll();
	}

	@Override
	public Laptop getById(int id) throws InvalidLaptopException {
		Optional<Laptop>  o= lr.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		else throw new InvalidLaptopException("no such laptop");
	}

	@Override
	public Laptop updateLaptop(LaptopDto ldto, int id) throws InvalidLaptopException {
		Optional<Laptop> o = lr.findById(id);
		if(o.isPresent()) {
			Laptop l = o.get();
			l.setBrand(ldto.getBrand());
			l.setPrice(ldto.getPrice());
			l.setUserId(ldto.getUserId());
			return lr.save(l);
		}
		else throw new InvalidLaptopException("no such laptop");
	}

	@Override
	public Laptop deleLaptop(int id) {
		Optional<Laptop> o = lr.findById(id);
		if(o.isPresent()) {
			lr.deleteById(id);
			return o.get();
		}
		else throw new InvalidLaptopException("no such laptop");
	}

	public List<Laptop> getByUserId(int id) {
	return lr.getByUserId(id);
		
	}

}
