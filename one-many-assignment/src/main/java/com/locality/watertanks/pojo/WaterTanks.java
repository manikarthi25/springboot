package com.locality.watertanks.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterTanks {

	private Integer localityId;
	private Integer capacity;
	private Date tankCleanedDate;

}
