package com.locality.watertanks.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locality")
public class LocalityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "locality")
	private String locality;

	@Column(name = "city")
	private String city;

	@OneToMany
	@JoinTable(name = "locality_water_tank_mapping", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "locality_id"))
	private List<WaterTanksEntity> waterTanksEntity;

}
