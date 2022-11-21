package com.tunahan.rentACar.service.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.rentACar.core.utilities.mapping.ModelMapperService;
import com.tunahan.rentACar.model.Car;
import com.tunahan.rentACar.repository.CarRepository;
import com.tunahan.rentACar.service.abstracts.CarService;
import com.tunahan.rentACar.service.requests.CreateCarRequest;
import com.tunahan.rentACar.service.requests.UpdateCarRequest;
import com.tunahan.rentACar.service.responses.CreateCarResponse;
import com.tunahan.rentACar.service.responses.GetAllCarResponse;
import com.tunahan.rentACar.service.responses.GetCarResponse;
import com.tunahan.rentACar.service.responses.UpdateCarResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	
	private final CarRepository carRepository;
	private final ModelMapperService mapperService;

	@Override
	public List<GetAllCarResponse> getAll() {
		return carRepository.findAll()
				.stream()
				.map(c-> mapperService.forResponse().map(c, GetAllCarResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<GetAllCarResponse> getByName(String name) {
		List<Car> cars = carRepository.findByName(name);
		return cars
				.stream()
				.map(c-> mapperService.forResponse().map(c, GetAllCarResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetCarResponse getById(int id) {
		Car car = carRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(car, GetCarResponse.class);
	}

	@Override
	public CreateCarResponse add(CreateCarRequest request) {
		Car car = mapperService.forResquest().map(request, Car.class);
		car.setId(0);
		carRepository.save(car);
		return mapperService.forResponse().map(car, CreateCarResponse.class);
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest request) {
		Car car = mapperService.forResquest().map(request, Car.class);
		carRepository.save(car);
		return mapperService.forResponse().map(car, UpdateCarResponse.class);
	}

	@Override
	public void deleteById(int id) {
		carRepository.deleteById(id);
		
	}

}
