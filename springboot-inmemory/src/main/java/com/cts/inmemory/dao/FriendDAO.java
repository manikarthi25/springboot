package com.cts.inmemory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.inmemory.entity.FriendEntity;
import com.cts.inmemory.pojo.Friend;
import com.cts.inmemory.repository.FriendRepository;

@Repository
public class FriendDAO {

	@Autowired
	private FriendRepository friendRepository;

	public List<Friend> addFriend(Friend friend) {
		FriendEntity friendEntity = new FriendEntity();
		friendEntity.setLocation(friend.getLocation());
		friendEntity.setName(friend.getName());
		friendRepository.save(friendEntity);

		List<FriendEntity> friendEntityList = friendRepository.findAll();
		List<Friend> friendList = new ArrayList<>();
		for (FriendEntity friendEnty : friendEntityList) {
			Friend fri = new Friend();
			fri.setId(friendEnty.getId());
			fri.setName(friendEnty.getName());
			fri.setLocation(friendEnty.getLocation());
			friendList.add(fri);
		}
		return friendList;

	}

	public Friend getFriendById(Integer id) {
		Optional<FriendEntity> optFriendEntity = friendRepository.findById(id);
		Friend friend = new Friend();
		if (optFriendEntity.isPresent()) {
			FriendEntity friendEntity = optFriendEntity.get();
			friend.setId(friendEntity.getId());
			friend.setName(friendEntity.getName());
			friend.setLocation(friendEntity.getLocation());
		}
		return friend;
	}

	public List<Friend> updateFriendById(Friend friend) {
		Optional<FriendEntity> optFriendEntity = friendRepository.findById(friend.getId());
		if (optFriendEntity.isPresent()) {
			FriendEntity friendEntity = optFriendEntity.get();
			friendEntity.setName(friend.getName());
			friendEntity.setLocation(friend.getLocation());
			friendRepository.saveAndFlush(friendEntity);
		}
		List<FriendEntity> friendEntityList = friendRepository.findAll();
		List<Friend> friendList = new ArrayList<>();
		for (FriendEntity friendEnty : friendEntityList) {
			Friend fri = new Friend();
			fri.setId(friendEnty.getId());
			fri.setName(friendEnty.getName());
			fri.setLocation(friendEnty.getLocation());
			friendList.add(fri);
		}
		return friendList;
	}

	public List<Friend> deleteFriendById(Integer id) {
		Optional<FriendEntity> optFriendEntity = friendRepository.findById(id);
		if (optFriendEntity.isPresent()) {
			friendRepository.deleteById(id);
		}
		List<FriendEntity> friendEntityList = friendRepository.findAll();
		List<Friend> friendList = new ArrayList<>();
		for (FriendEntity friendEnty : friendEntityList) {
			Friend fri = new Friend();
			fri.setId(friendEnty.getId());
			fri.setName(friendEnty.getName());
			fri.setLocation(friendEnty.getLocation());
			friendList.add(fri);
		}
		return friendList;
	}

	public List<Friend> getAllFriends() {
		List<FriendEntity> friendEntityList = friendRepository.findAll();
		List<Friend> friendList = new ArrayList<>();
		for (FriendEntity friendEnty : friendEntityList) {
			Friend fri = new Friend();
			fri.setId(friendEnty.getId());
			fri.setName(friendEnty.getName());
			fri.setLocation(friendEnty.getLocation());
			friendList.add(fri);
		}
		return friendList;
	}

}
