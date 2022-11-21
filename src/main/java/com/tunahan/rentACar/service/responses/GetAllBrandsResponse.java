package com.tunahan.rentACar.service.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBrandsResponse {
	
	private int id;
	private String name;
	private List<GetAllCarResponse> cars;
}
