package com.locality.watertanks.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.locality.watertanks.entity.LocalityEntity;
import com.locality.watertanks.entity.WaterTanksEntity;
import com.locality.watertanks.pojo.Locality;
import com.locality.watertanks.pojo.WaterTanks;
import com.locality.watertanks.repository.LocalityRepository;
import com.locality.watertanks.repository.WaterTanksRepository;

@Repository
public class LocalityWaterTanksDAO {

	@Autowired
	private LocalityRepository localityRepository;

	@Autowired
	private WaterTanksRepository waterTanksRepository;

	public List<Locality> addLocalityWithWaterTankInformation(Locality locality) {
		LocalityEntity localityEntity = new LocalityEntity();
		localityEntity.setStreetName(locality.getStreetName());
		localityEntity.setLocality(locality.getLocality());
		localityEntity.setCity(locality.getCity());

		List<WaterTanksEntity> waterTankEntityList = new ArrayList<>();
		for (WaterTanks waterTank : locality.getWaterTankList()) {
			WaterTanksEntity waterTanksEntity = new WaterTanksEntity();
			waterTanksEntity.setCapacity(waterTank.getCapacity());
			waterTanksEntity.setTankCleanedDate(waterTank.getTankCleanedDate());
			waterTanksRepository.save(waterTanksEntity);
			waterTankEntityList.add(waterTanksEntity);
		}

		localityEntity.setWaterTanksEntity(waterTankEntityList);

		localityRepository.save(localityEntity);

		List<LocalityEntity> localityEntityList = localityRepository.findAll();
		List<Locality> localityList = new ArrayList<>();
		for (LocalityEntity localityEnty : localityEntityList) {
			Locality local = getLocalityFromEntity(localityEnty);
			localityList.add(local);
		}
		return localityList;
	}

	public Locality searchById(Integer id) {
		Optional<LocalityEntity> optLocalityEntity = localityRepository.findById(id);
		Locality locality = new Locality();
		if (optLocalityEntity.isPresent()) {
			locality = getLocalityFromEntity(optLocalityEntity.get());
		}
		return locality;
	}

	public List<Locality> getWaterTankDetails() {
		return getAllLocalityDetails();
	}

	public List<Locality> updateLocality(Locality locality) {
		Optional<LocalityEntity> optLocalityEntity = localityRepository.findById(locality.getId());
		if (optLocalityEntity.isPresent()) {
			LocalityEntity localityEntity = optLocalityEntity.get();
			localityEntity.setStreetName(locality.getStreetName());
			localityEntity.setLocality(locality.getLocality());
			localityEntity.setCity(locality.getCity());

			List<WaterTanksEntity> waterTankEntityList = new ArrayList<>();
			for (WaterTanks waterTank : locality.getWaterTankList()) {
				WaterTanksEntity waterTanksEntity = new WaterTanksEntity();
				waterTanksEntity.setCapacity(waterTank.getCapacity());
				waterTanksEntity.setTankCleanedDate(waterTank.getTankCleanedDate());
				waterTanksRepository.saveAndFlush(waterTanksEntity);
				waterTankEntityList.add(waterTanksEntity);
			}

			localityEntity.setWaterTanksEntity(waterTankEntityList);

			localityRepository.saveAndFlush(localityEntity);
		}
		return getAllLocalityDetails();
	}

	public List<Locality> deleteLocalityById(Integer id) {
		Optional<LocalityEntity> optLocalityEntity = localityRepository.findById(id);
		if (optLocalityEntity.isPresent()) {
			localityRepository.deleteById(id);
		}
		return getAllLocalityDetails();
	}

	private Locality getLocalityFromEntity(LocalityEntity localityEntity) {
		Locality locality = new Locality();
		locality.setId(localityEntity.getId());
		locality.setStreetName(localityEntity.getStreetName());
		locality.setLocality(localityEntity.getLocality());
		locality.setCity(localityEntity.getCity());
		List<WaterTanks> waterTanksList = new ArrayList<>();
		for (WaterTanksEntity waterTankEntity : localityEntity.getWaterTanksEntity()) {
			WaterTanks waterTanks = new WaterTanks();
			waterTanks.setLocalityId(waterTankEntity.getLocalityId());
			waterTanks.setCapacity(waterTankEntity.getCapacity());
			waterTanks.setTankCleanedDate(waterTankEntity.getTankCleanedDate());
			waterTanksList.add(waterTanks);
		}
		locality.setWaterTankList(waterTanksList);
		return locality;
	}

	private List<Locality> getAllLocalityDetails() {
		List<LocalityEntity> localityEntityList = localityRepository.findAll();
		List<Locality> localityList = new ArrayList<>();
		for (LocalityEntity localityEnty : localityEntityList) {
			Locality local = getLocalityFromEntity(localityEnty);
			localityList.add(local);
		}
		return localityList;
	}

}
