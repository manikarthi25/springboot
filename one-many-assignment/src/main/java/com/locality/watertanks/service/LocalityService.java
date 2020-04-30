package com.locality.watertanks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locality.watertanks.dao.LocalityWaterTanksDAO;
import com.locality.watertanks.pojo.Locality;

@Service
public class LocalityService {

	@Autowired
	private LocalityWaterTanksDAO localityWaterTanksDAO;

	public List<Locality> addLocalityWithWaterTankInformation(Locality locality) {
		return localityWaterTanksDAO.addLocalityWithWaterTankInformation(locality);
	}

	public Locality searchById(Integer id) {
		return localityWaterTanksDAO.searchById(id);
	}
	
	public List<Locality> getWaterTankDetails() {
		return localityWaterTanksDAO.getWaterTankDetails();
	}

	public List<Locality> updateLocality(Locality locality) {
		return localityWaterTanksDAO.updateLocality(locality);
	}

	public List<Locality> deleteLocalityById(Integer id) {
		return localityWaterTanksDAO.deleteLocalityById(id);
	}

}
