package com.cts.inmemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.inmemory.entity.FriendEntity;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

}


