package com.tild.desafio.controller;

import com.tild.desafio.blog.domain.Post;
import com.tild.desafio.blog.model.IModelPost;
import com.tild.desafio.blog.model.IModelUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostsController {

	private IModelPost modelPost;
	private IModelUser modelUser;
	
	@Autowired
	public PostsController(IModelPost modelPost, IModelUser modelUser) {
		this.modelPost = modelPost;
		this.modelUser = modelUser;
	}

	@GetMapping("/new")
	public ModelAndView newPost() {
		ModelAndView mv = new ModelAndView("new");

		mv.addObject("users", modelUser.findAll());
		mv.addObject("newPost", new Post());

		return mv;
	}
	
	@GetMapping("/post/{tag}")
	public ModelAndView gato(@PathVariable("tag") String tag) {
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("posts", modelPost.findByOneTag(tag));
		
		return mv;
	}

	@PostMapping
	public ModelAndView createPost(Post post) {
		
		modelPost.save(post);

		return new ModelAndView("redirect:/");
	}
}
