package com.vipin.SocialMediaApp.service;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.vipin.SocialMediaApp.model.User;

import java.util.Optional;

@Service
public class UserService {
	
	public static List<User>  userList = new ArrayList<User>();
	
	static {
		  userList.add(new User(1,"Vipin",LocalDate.now().minusYears(41)));
		  userList.add(new User(2,"Vineeth",LocalDate.now().minusYears(39)));
		  userList.add(new User(3,"Ranjith",LocalDate.now().minusYears(35)));
	}
	
	public User getUserbyId(Integer id)
	{
		User usr = userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		return usr;
	}
		
	public Integer deleteUser(Integer id)
	{
		Integer ret=0;
		try
		{
	      userList.removeIf(obj -> obj.getId() == id);
	      ret =1;
		}
		catch(Exception e)
		{
	      ret =2;		
		}
	return ret;
	}
	
	public User createUser(User user)
	{
		user.setId(userList.stream().map(User::getId).max(Comparator.naturalOrder()).orElse(0)+1);
		userList.add(user);
		return user;
	}

}
