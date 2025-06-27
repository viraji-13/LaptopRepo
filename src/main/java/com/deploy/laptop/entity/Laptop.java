package com.deploy.laptop.entity;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Laptop {

	
	
	
	public Laptop(String brand, int price, int userId) {
		super();
		this.brand = brand;
		this.price = price;
		this.userId = userId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String brand;
	int price;
	int userId;
}
