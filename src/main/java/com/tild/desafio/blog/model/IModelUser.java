package com.tild.desafio.blog.model;

import java.util.List;

import org.springframework.stereotype.Component;
import com.tild.desafio.blog.domain.User;

@Component
public interface IModelUser {
	
	public List<User> findAll();

	public void save(User user);
}
