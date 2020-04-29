package com.cts.inmemory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.inmemory.pojo.Friend;
import com.cts.inmemory.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	private FriendService friendService;

	@GetMapping("/")
	public String getWelcomeMessage() {
		return "Welcome to CTS";
	}

	@PostMapping("/add")
	public List<Friend> addFriend(@RequestBody Friend friend) {
		return friendService.addFriend(friend);
	}

	@GetMapping("/search/{id}")
	public Friend getFriendById(@PathVariable Integer id) {
		return friendService.getFriendById(id);
	}

	@GetMapping("/search/all")
	public List<Friend> getAllFriends() {
		return friendService.getAllFriends();
	}

	@PutMapping("/update")
	public List<Friend> updateFriendById(@RequestBody Friend friend) {
		return friendService.updateFriendById(friend);
	}

	@DeleteMapping("/delete/{id}")
	public List<Friend> deleteFriendById(@PathVariable Integer id) {
		return friendService.deleteFriendById(id);
	}

}
