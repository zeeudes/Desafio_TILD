package com.tild.desafio.blog.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tild.desafio.blog.data.UserRepository;
import com.tild.desafio.blog.domain.User;

@Component
public class ModelUser implements IModelUser{
	
	private UserRepository userRepository;
	
	@Autowired
	public ModelUser(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	public void save(User user) {
		userRepository.save(user);
	}
}
