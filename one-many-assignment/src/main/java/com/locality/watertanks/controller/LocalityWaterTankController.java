package com.locality.watertanks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.locality.watertanks.pojo.Locality;
import com.locality.watertanks.service.LocalityService;

@RestController
public class LocalityWaterTankController {

	@Autowired
	private LocalityService localityService;

	@GetMapping("/")
	public String getWelcomeMessage() {
		return "Welcome to Springboot - One to Many Relation Example";
	}

	@PostMapping("/add")
	public List<Locality> addLocalityWithWaterTankInformation(@RequestBody Locality locality) {
		return localityService.addLocalityWithWaterTankInformation(locality);
	}

	@GetMapping("/search/{id}")
	public Locality searchById(@PathVariable Integer id) {
		return localityService.searchById(id);
	}

	@GetMapping("/search/all")
	public List<Locality> getWaterTankDetails() {
		return localityService.getWaterTankDetails();
	}

	@PutMapping("/update")
	public List<Locality> updateLocality(@RequestBody Locality locality) {
		return localityService.updateLocality(locality);
	}

	@DeleteMapping("/delete/{id}")
	public List<Locality> deleteLocalityById(@PathVariable Integer id) {
		return localityService.deleteLocalityById(id);
	} 

}
