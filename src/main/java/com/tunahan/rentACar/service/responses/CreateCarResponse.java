package com.tunahan.rentACar.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarResponse {

	private int id;
	private int brandId;
	private String name;
	private double unitPrice;
	private int unitsInStock;
}
