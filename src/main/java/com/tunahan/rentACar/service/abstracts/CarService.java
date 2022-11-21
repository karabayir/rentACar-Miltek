package com.tunahan.rentACar.service.abstracts;

import java.util.List;

import com.tunahan.rentACar.service.requests.CreateCarRequest;
import com.tunahan.rentACar.service.requests.UpdateCarRequest;
import com.tunahan.rentACar.service.responses.CreateCarResponse;
import com.tunahan.rentACar.service.responses.GetAllCarResponse;
import com.tunahan.rentACar.service.responses.GetCarResponse;
import com.tunahan.rentACar.service.responses.UpdateCarResponse;

public interface CarService {

	List<GetAllCarResponse> getAll();
	
	List<GetAllCarResponse> getByName(String name);
	
	GetCarResponse getById(int id);
	
	CreateCarResponse add(CreateCarRequest request);
	
	UpdateCarResponse update(UpdateCarRequest request);
	
	void deleteById(int id);
}
