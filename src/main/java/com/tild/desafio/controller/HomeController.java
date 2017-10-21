package com.tild.desafio.controller;

import com.tild.desafio.blog.model.IModelPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private IModelPost modelPost;
    
	@Autowired
	public HomeController(IModelPost modelPost) {
		this.modelPost = modelPost;
	}

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("posts", modelPost.findAll());

        return mv;
    }
}
