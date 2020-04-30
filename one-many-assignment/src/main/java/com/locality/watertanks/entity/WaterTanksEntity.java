package com.locality.watertanks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "water_tank")
public class WaterTanksEntity {

	@Id
	@Column(name = "locality_Id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer localityId;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "tank_cleaned_date")
	private Date tankCleanedDate;

}
