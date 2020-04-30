package com.locality.watertanks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locality.watertanks.entity.LocalityEntity;

@Repository
public interface LocalityRepository extends JpaRepository<LocalityEntity, Integer> {

}


