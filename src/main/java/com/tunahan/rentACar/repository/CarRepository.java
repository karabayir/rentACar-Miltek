package com.tunahan.rentACar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.rentACar.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	 List<Car> findByName(String name);
}
