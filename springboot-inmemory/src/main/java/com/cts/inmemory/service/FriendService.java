package com.cts.inmemory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.inmemory.dao.FriendDAO;
import com.cts.inmemory.pojo.Friend;

@Service
public class FriendService {

	@Autowired
	private FriendDAO friendDAO;

	public List<Friend> addFriend(Friend friend) {
		return friendDAO.addFriend(friend);

	}

	public Friend getFriendById(Integer id) {
		return friendDAO.getFriendById(id);
	}

	public List<Friend> updateFriendById(Friend friend) {
		return friendDAO.updateFriendById(friend);
	}

	public List<Friend> deleteFriendById(Integer id) {
		return friendDAO.deleteFriendById(id);
	}

	public List<Friend> getAllFriends() {
		return friendDAO.getAllFriends();
	}

}
