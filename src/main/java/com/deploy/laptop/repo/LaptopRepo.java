package com.deploy.laptop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deploy.laptop.entity.Laptop;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

	public  List<Laptop> getByUserId(int id);

	
}
