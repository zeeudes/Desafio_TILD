package com.tild.desafio.blog.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tild.desafio.blog.domain.Post;

@Component
public interface IModelPost {
	
	public List<Post> findByOneTag(String tag);

	public void save(Post post);

	public Object findAll();
}
