package com.tunahan.rentACar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.rentACar.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

	List<Brand> findByName(String name);
}
