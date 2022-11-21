package com.tunahan.rentACar.service.abstracts;

import java.util.List;

import com.tunahan.rentACar.service.requests.CreateBrandRequest;
import com.tunahan.rentACar.service.requests.UpdateBrandRequest;
import com.tunahan.rentACar.service.responses.CreateBrandResponse;
import com.tunahan.rentACar.service.responses.GetAllBrandsResponse;
import com.tunahan.rentACar.service.responses.GetBrandResponse;
import com.tunahan.rentACar.service.responses.UpdateBrandResponse;

public interface BrandService {

	 List<GetAllBrandsResponse> getAll();
	 
	 List<GetAllBrandsResponse> getAllByName(String name);
	 
	 GetBrandResponse getById(int id);
	 
	 CreateBrandResponse add(CreateBrandRequest request);
	 
	 UpdateBrandResponse updateById(UpdateBrandRequest request);
	 
	 void deleteById(int id);
}
