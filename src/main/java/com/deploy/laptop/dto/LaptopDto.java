package com.deploy.laptop.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDto {

	
	@NotBlank(message = "it cant be empty")
	String brand;
	
	@NotNull(message = "it cant be empty")
	int price;
	
	@NotNull(message ="it cant be null")
	int userId;
	
	
	
}
