package com.tunahan.rentACar.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.rentACar.service.abstracts.CarService;
import com.tunahan.rentACar.service.requests.CreateCarRequest;
import com.tunahan.rentACar.service.requests.UpdateCarRequest;
import com.tunahan.rentACar.service.responses.CreateCarResponse;
import com.tunahan.rentACar.service.responses.GetAllCarResponse;
import com.tunahan.rentACar.service.responses.GetCarResponse;
import com.tunahan.rentACar.service.responses.UpdateCarResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/cars/")
@AllArgsConstructor
public class CarController {

	private final CarService carService;
	
	@GetMapping("getAll")
	List<GetAllCarResponse> getAll(){
		return carService.getAll();
	}
	
	@GetMapping("getAllByName")
	List<GetAllCarResponse> getByName(String name){
		return carService.getByName(name);
	}
	
	@GetMapping("getById/{id}")
	GetCarResponse getById(@PathVariable int id) {
		return carService.getById(id);
	}
	
	@PostMapping("add")
	CreateCarResponse add(CreateCarRequest request) {
		return carService.add(request);
	}
	
	@PutMapping("update")
	UpdateCarResponse update(UpdateCarRequest request) {
		return carService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	void deleteById(@PathVariable int id) {
		 carService.deleteById(id);
	}
}
