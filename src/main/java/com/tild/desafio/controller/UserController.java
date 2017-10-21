package com.tild.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tild.desafio.blog.domain.User;
import com.tild.desafio.blog.model.IModelUser;

@Controller
@RequestMapping("/user")
public class UserController {

	private IModelUser modelUser;

	@Autowired
	public UserController(IModelUser modelUser) {
		this.modelUser = modelUser;
	}

	@GetMapping("/new")
	public ModelAndView newPost() {
		ModelAndView mv = new ModelAndView("user");

		mv.addObject("newUser", new User());

		return mv;
	}

	@PostMapping
	public ModelAndView createUser(User user) {
		modelUser.save(user);

		return new ModelAndView("redirect:/");
	}
}
