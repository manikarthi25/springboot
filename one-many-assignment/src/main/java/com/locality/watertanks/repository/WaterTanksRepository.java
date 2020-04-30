package com.locality.watertanks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locality.watertanks.entity.WaterTanksEntity;

public interface WaterTanksRepository extends JpaRepository<WaterTanksEntity, Integer> {

}
