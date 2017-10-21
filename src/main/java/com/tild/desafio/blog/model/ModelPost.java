package com.tild.desafio.blog.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tild.desafio.blog.data.PostRepository;
import com.tild.desafio.blog.domain.Post;

@Component
public class ModelPost implements IModelPost{
	
	private PostRepository postRepository;
	
	@Autowired
	public ModelPost(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	public List<Post> findByOneTag(String tag){
		List<Post> posts = new ArrayList<>();
	
		postRepository.findAll().stream().filter(p -> p.getTags().contains(tag)).forEach(p -> posts.add(p));
		
		return posts;
	}
	public void save(Post post) {
		post.setTags(post.getTags().toUpperCase());
		
		if(post.isValid())
			postRepository.save(post);
	}
	public List<Post> findAll() {
		return postRepository.findAll();
	}
}
