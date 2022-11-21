package com.tunahan.rentACar.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.rentACar.service.abstracts.BrandService;
import com.tunahan.rentACar.service.requests.CreateBrandRequest;
import com.tunahan.rentACar.service.requests.UpdateBrandRequest;
import com.tunahan.rentACar.service.responses.CreateBrandResponse;
import com.tunahan.rentACar.service.responses.GetAllBrandsResponse;
import com.tunahan.rentACar.service.responses.GetBrandResponse;
import com.tunahan.rentACar.service.responses.UpdateBrandResponse;

@RestController
@RequestMapping("/api/v1/brands/")
public class BrandController {
	
	private final BrandService brandService;

	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping("getAll")
	public List<GetAllBrandsResponse> getAll(){	
		return brandService.getAll();
	} 
	
	@GetMapping("getAllByName")
	List<GetAllBrandsResponse> getAllByName(String name){
		return brandService.getAllByName(name);
	}
	
	@GetMapping("getById/{id}")
	GetBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping("add")
	public CreateBrandResponse add(CreateBrandRequest request) {
		return brandService.add(request);
	}
	
	@PutMapping("update")
	UpdateBrandResponse updateById(UpdateBrandRequest request) {
		return brandService.updateById(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	void deleteById(@PathVariable int id) {
		brandService.deleteById(id);
	}
	
}
