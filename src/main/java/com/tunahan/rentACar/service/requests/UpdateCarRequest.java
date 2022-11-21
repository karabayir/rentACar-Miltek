package com.tunahan.rentACar.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {

	private int id;
	private int brandId;
	private String name;
	private int unitsInStock;
	private double unitPrice;
}
