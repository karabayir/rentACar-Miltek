package com.tunahan.rentACar.service.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.rentACar.core.utilities.mapping.ModelMapperService;
import com.tunahan.rentACar.model.Brand;
import com.tunahan.rentACar.repository.BrandRepository;
import com.tunahan.rentACar.service.abstracts.BrandService;
import com.tunahan.rentACar.service.requests.CreateBrandRequest;
import com.tunahan.rentACar.service.requests.UpdateBrandRequest;
import com.tunahan.rentACar.service.responses.CreateBrandResponse;
import com.tunahan.rentACar.service.responses.GetAllBrandsResponse;
import com.tunahan.rentACar.service.responses.GetBrandResponse;
import com.tunahan.rentACar.service.responses.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	
    private final BrandRepository brandRepository;
    private final ModelMapperService mapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		return brandRepository.findAll()
				.stream()
				.map(b-> mapperService.forResponse().map(b, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<GetAllBrandsResponse> getAllByName(String name) {
		List<Brand> brands = brandRepository.findByName(name);	
		return brands
				.stream()
				.map(b->mapperService.forResponse().map(b, GetAllBrandsResponse.class))
				.collect(Collectors.toList());			
	}

	@Override
	public GetBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(brand, GetBrandResponse.class);
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest request) {
		Brand brand = mapperService.forResquest().map(request, Brand.class);
		brandRepository.save(brand);
		return mapperService.forResponse().map(brand, CreateBrandResponse.class);
	}

	@Override
	public UpdateBrandResponse updateById(UpdateBrandRequest request) {
		Brand brand =mapperService.forResquest().map(request, Brand.class);
		brandRepository.save(brand);
		return mapperService.forResponse().map(brand, UpdateBrandResponse.class);
	}

	@Override
	public void deleteById(int id) {
		brandRepository.deleteById(id);
	}

}
