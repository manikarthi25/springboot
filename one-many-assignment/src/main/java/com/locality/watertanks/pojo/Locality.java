package com.locality.watertanks.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locality {

	private Integer id;
	private String streetName;
	private String locality;
	private String city;
	private List<WaterTanks> waterTankList;

}
